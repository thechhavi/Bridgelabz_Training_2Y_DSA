import java.util.Scanner;

class State {
    String text;
    State prev, next;

    State(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

public class UndoRedoDLL {

    static State head = null;
    static State tail = null;
    static State current = null;
    static int count = 0;
    static final int LIMIT = 10;

    // Add new text state
    static void addState(String text) {

        State newState = new State(text);

        // If current is not at tail → delete redo history
        if (current != null && current.next != null) {
            State temp = current.next;
            while (temp != null) {
                State next = temp.next;
                temp.prev = temp.next = null;
                temp = next;
                count--;
            }
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newState;
            count = 1;
            return;
        }

        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        count++;

        // Maintain limit
        if (count > LIMIT) {
            head = head.next;
            head.prev = null;
            count--;
        }
    }

    // Undo
    static void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo");
            return;
        }

        current = current.prev;
        System.out.println("Undo done");
    }

    // Redo
    static void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo");
            return;
        }

        current = current.next;
        System.out.println("Redo done");
    }

    // Display current text
    static void displayCurrent() {
        if (current == null) {
            System.out.println("Editor empty");
            return;
        }

        System.out.println("Current Text: " + current.text);
    }

    // Display full history (for debugging / viva)
    static void displayHistory() {
        State temp = head;
        System.out.println("History:");
        while (temp != null) {
            if (temp == current)
                System.out.println("[" + temp.text + "] <- current");
            else
                System.out.println(temp.text);
            temp = temp.next;
        }
    }

    // Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\\n--- Undo/Redo Menu ---");
            System.out.println("1.Type Text");
            System.out.println("2.Undo");
            System.out.println("3.Redo");
            System.out.println("4.Display Current");
            System.out.println("5.Display History");
            System.out.println("6.Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    addState(text);
                    break;

                case 2:
                    undo();
                    break;

                case 3:
                    redo();
                    break;

                case 4:
                    displayCurrent();
                    break;

                case 5:
                    displayHistory();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
