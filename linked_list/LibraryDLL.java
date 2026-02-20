
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    String genre;
    String status;
    Book next, prev;

    Book(int id, String title, String author, String genre, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryDLL {

    static Book head = null;
    static Book tail = null;

    // Insert at beginning
    static void insertAtBeginning(int id, String title, String author, String genre, String status) {
        Book newBook = new Book(id, title, author, genre, status);

        if (head == null) {
            head = tail = newBook;
            return;
        }

        newBook.next = head;
        head.prev = newBook;
        head = newBook;
    }

    // Insert at end
    static void insertAtEnd(int id, String title, String author, String genre, String status) {
        Book newBook = new Book(id, title, author, genre, status);

        if (head == null) {
            head = tail = newBook;
            return;
        }

        tail.next = newBook;
        newBook.prev = tail;
        tail = newBook;
    }

    // Insert at position
    static void insertAtPosition(int id, String title, String author, String genre, String status, int pos) {
        if (pos == 1) {
            insertAtBeginning(id, title, author, genre, status);
            return;
        }

        Book temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        Book newBook = new Book(id, title, author, genre, status);

        newBook.next = temp.next;
        newBook.prev = temp;

        if (temp.next != null)
            temp.next.prev = newBook;
        else
            tail = newBook;

        temp.next = newBook;
    }

    // Delete by ID
    static void deleteById(int id) {
        Book temp = head;

        while (temp != null && temp.id != id)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Book not found");
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

        System.out.println("Book deleted");
    }

    // Search by title
    static void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found");
    }

    // Search by author
    static void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found");
    }

    // Update availability
    static void updateStatus(int id, String newStatus) {
        Book temp = head;

        while (temp != null) {
            if (temp.id == id) {
                temp.status = newStatus;
                System.out.println("Status updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found");
    }

    // Display forward
    static void displayForward() {
        if (head == null) {
            System.out.println("Library empty");
            return;
        }

        Book temp = head;
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    static void displayReverse() {
        if (tail == null) {
            System.out.println("Library empty");
            return;
        }

        Book temp = tail;
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    // Count books
    static void countBooks() {
        int count = 0;
        Book temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total books = " + count);
    }

    // Print book details
    static void printBook(Book b) {
        System.out.println(b.id + " " + b.title + " " + b.author + " " + b.genre + " " + b.status);
    }

    // Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\\n--- Library Menu ---");
            System.out.println("1.Insert at Beginning");
            System.out.println("2.Insert at End");
            System.out.println("3.Insert at Position");
            System.out.println("4.Delete by ID");
            System.out.println("5.Search by Title");
            System.out.println("6.Search by Author");
            System.out.println("7.Update Status");
            System.out.println("8.Display Forward");
            System.out.println("9.Display Reverse");
            System.out.println("10.Count Books");
            System.out.println("11.Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertAtBeginning(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next());
                    break;

                case 2:
                    insertAtEnd(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next());
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    insertAtPosition(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(), pos);
                    break;

                case 4:
                    deleteById(sc.nextInt());
                    break;

                case 5:
                    searchByTitle(sc.next());
                    break;

                case 6:
                    searchByAuthor(sc.next());
                    break;

                case 7:
                    updateStatus(sc.nextInt(), sc.next());
                    break;

                case 8:
                    displayForward();
                    break;

                case 9:
                    displayReverse();
                    break;

                case 10:
                    countBooks();
                    break;

                case 11:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
