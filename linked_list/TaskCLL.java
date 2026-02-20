import java.util.Scanner;

class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskCLL {

    static Task head = null;
    static Task current = null;

    // Insert at beginning
    static void insertAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
            return;
        }

        Task last = head;
        while (last.next != head) {
            last = last.next;
        }

        newTask.next = head;
        last.next = newTask;
        head = newTask;
    }

    // Insert at end
    static void insertAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
            return;
        }

        Task last = head;
        while (last.next != head) {
            last = last.next;
        }

        last.next = newTask;
        newTask.next = head;
    }

    // Insert at position
    static void insertAtPosition(int id, String name, int priority, String dueDate, int pos) {
        if (pos == 1) {
            insertAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task temp = head;

        for (int i = 1; temp.next != head && i < pos - 1; i++) {
            temp = temp.next;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Delete by Task ID
    static void deleteTask(int id) {
        if (head == null) {
            System.out.println("No tasks");
            return;
        }

        Task temp = head, prev = null;

        // If head is to be deleted
        if (head.id == id) {
            Task last = head;
            while (last.next != head) {
                last = last.next;
            }

            if (head.next == head) {
                head = null;
                current = null;
                return;
            }

            head = head.next;
            last.next = head;

            if (current.id == id)
                current = head;

            System.out.println("Task deleted");
            return;
        }

        do {
            prev = temp;
            temp = temp.next;

            if (temp.id == id) {
                prev.next = temp.next;

                if (current.id == id)
                    current = temp.next;

                System.out.println("Task deleted");
                return;
            }

        } while (temp != head);

        System.out.println("Task not found");
    }

    // View current task and move to next
    static void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available");
            return;
        }

        System.out.println("Current Task:");
        System.out.println(current.id + " " + current.name +
                " Priority:" + current.priority + " Due:" + current.dueDate);

        current = current.next; // move circularly
    }

    // Display all tasks
    static void displayTasks() {
        if (head == null) {
            System.out.println("No tasks");
            return;
        }

        Task temp = head;
        System.out.println("Task List:");
        do {
            System.out.println(temp.id + " " + temp.name + " " +
                    temp.priority + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    static void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                System.out.println(temp.id + " " + temp.name + " Due:" + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No task with this priority");
    }

    // Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\\n--- Task Scheduler Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Task ID");
            System.out.println("5. View Current Task (Move Next)");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search by Priority");
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
                    deleteTask(sc.nextInt());
                    break;

                case 5:
                    viewCurrentTask();
                    break;

                case 6:
                    displayTasks();
                    break;

                case 7:
                    searchByPriority(sc.nextInt());
                    break;

                case 8:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
