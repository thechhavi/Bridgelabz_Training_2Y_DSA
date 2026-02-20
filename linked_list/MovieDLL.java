import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next, prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class MovieDLL {

    static Movie head = null;
    static Movie tail = null;

    // Insert at beginning
    static void insertAtBeginning(String title, String director, int year, double rating) {
        Movie newNode = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insert at end
    static void insertAtEnd(String title, String director, int year, double rating) {
        Movie newNode = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Insert at position
    static void insertAtPosition(String title, String director, int year, double rating, int pos) {
        if (pos == 1) {
            insertAtBeginning(title, director, year, rating);
            return;
        }

        Movie temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        Movie newNode = new Movie(title, director, year, rating);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null)
            temp.next.prev = newNode;
        else
            tail = newNode;

        temp.next = newNode;
    }

    // Delete by title
    static void deleteByTitle(String title) {
        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }

        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;
        else
            tail = temp.prev;

        System.out.println("Movie deleted");
    }

    // Search by director
    static void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + " " + temp.year + " " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found for this director");
    }

    // Search by rating
    static void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + " " + temp.director + " " + temp.year);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found with this rating");
    }

    // Update rating by title
    static void updateRating(String title, double newRating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    // Display forward
    static void displayForward() {
        Movie temp = head;

        if (temp == null) {
            System.out.println("List is empty");
            return;
        }

        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.year + " " + temp.rating);
            temp = temp.next;
        }
    }

    // Display reverse
    static void displayReverse() {
        Movie temp = tail;

        if (temp == null) {
            System.out.println("List is empty");
            return;
        }

        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.year + " " + temp.rating);
            temp = temp.prev;
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\\n--- Movie Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Update Rating");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("10. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertAtBeginning(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 2:
                    insertAtEnd(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    insertAtPosition(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), pos);
                    break;

                case 4:
                    deleteByTitle(sc.next());
                    break;

                case 5:
                    searchByDirector(sc.next());
                    break;

                case 6:
                    searchByRating(sc.nextDouble());
                    break;

                case 7:
                    updateRating(sc.next(), sc.nextDouble());
                    break;

                case 8:
                    displayForward();
                    break;

                case 9:
                    displayReverse();
                    break;

                case 10:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
