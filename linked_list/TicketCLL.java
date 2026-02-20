import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int id, String cname, String mname, String seat, String time) {
        ticketId = id;
        customerName = cname;
        movieName = mname;
        seatNumber = seat;
        bookingTime = time;
        next = null;
    }
}

public class TicketCLL {

    static Ticket head = null;

    // Add ticket at end
    static void addTicket(int id, String cname, String mname, String seat, String time) {
        Ticket newTicket = new Ticket(id, cname, mname, seat, time);

        if (head == null) {
            head = newTicket;
            newTicket.next = head;
            return;
        }

        Ticket temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newTicket;
        newTicket.next = head;
    }

    // Delete ticket by ID
    static void deleteTicket(int id) {
        if (head == null) {
            System.out.println("No tickets");
            return;
        }

        Ticket temp = head, prev = null;

        // If head to delete
        if (head.ticketId == id) {
            Ticket last = head;
            while (last.next != head)
                last = last.next;

            if (head.next == head) {
                head = null;
                System.out.println("Ticket deleted");
                return;
            }

            head = head.next;
            last.next = head;
            System.out.println("Ticket deleted");
            return;
        }

        do {
            prev = temp;
            temp = temp.next;

            if (temp.ticketId == id) {
                prev.next = temp.next;
                System.out.println("Ticket deleted");
                return;
            }

        } while (temp != head);

        System.out.println("Ticket not found");
    }

    // Display all tickets
    static void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;
        System.out.println("Ticket List:");

        do {
            System.out.println(temp.ticketId + " " + temp.customerName + " " +
                    temp.movieName + " Seat:" + temp.seatNumber +
                    " Time:" + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by customer name
    static void searchByCustomer(String name) {
        if (head == null) {
            System.out.println("No tickets");
            return;
        }

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(name)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found for this customer");
    }

    // Search by movie name
    static void searchByMovie(String movie) {
        if (head == null) {
            System.out.println("No tickets");
            return;
        }

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tickets found for this movie");
    }

    // Count tickets
    static void countTickets() {
        if (head == null) {
            System.out.println("Total tickets = 0");
            return;
        }

        int count = 0;
        Ticket temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total tickets = " + count);
    }

    // Print ticket details
    static void printTicket(Ticket t) {
        System.out.println(t.ticketId + " " + t.customerName + " " +
                t.movieName + " Seat:" + t.seatNumber +
                " Time:" + t.bookingTime);
    }

    // Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\\n--- Ticket Reservation Menu ---");
            System.out.println("1.Add Ticket");
            System.out.println("2.Delete Ticket");
            System.out.println("3.Display Tickets");
            System.out.println("4.Search by Customer");
            System.out.println("5.Search by Movie");
            System.out.println("6.Count Tickets");
            System.out.println("7.Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addTicket(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next());
                    break;

                case 2:
                    deleteTicket(sc.nextInt());
                    break;

                case 3:
                    displayTickets();
                    break;

                case 4:
                    searchByCustomer(sc.next());
                    break;

                case 5:
                    searchByMovie(sc.next());
                    break;

                case 6:
                    countTickets();
                    break;

                case 7:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
