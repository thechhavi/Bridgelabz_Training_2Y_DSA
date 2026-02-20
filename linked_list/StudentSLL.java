import java.util.Scanner;

class Student {
    int roll;
    String name;
    int age;
    String grade;
    Student next;

    Student(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentSLL {

    static Student head = null;

    // Insert at beginning
    static void insertAtBeginning(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    static void insertAtEnd(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert at specific position
    static void insertAtPosition(int roll, String name, int age, String grade, int pos) {
        Student newNode = new Student(roll, name, age, grade);

        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Student temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by roll number
    static void deleteByRoll(int roll) {
        Student temp = head, prev = null;

        while (temp != null && temp.roll != roll) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Student not found");
            return;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = temp.next;
        }

        System.out.println("Student deleted");
    }

    // Search by roll number
    static void search(int roll) {
        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Found: " + temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    // Update grade
    static void updateGrade(int roll, String newGrade) {
        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    // Display all students
    static void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\\n--- Student Record Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Roll");
            System.out.println("5. Search by Roll");
            System.out.println("6. Update Grade");
            System.out.println("7. Display");
            System.out.println("8. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;

                case 2:
                    insertAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    insertAtPosition(sc.nextInt(), sc.next(), sc.nextInt(), sc.next(), pos);
                    break;

                case 4:
                    deleteByRoll(sc.nextInt());
                    break;

                case 5:
                    search(sc.nextInt());
                    break;

                case 6:
                    updateGrade(sc.nextInt(), sc.next());
                    break;

                case 7:
                    display();
                    break;

                case 8:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
