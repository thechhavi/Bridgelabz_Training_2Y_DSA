import java.util.Scanner;

class Item {
    int id, quantity;
    String name;
    double price;
    Item next;

    Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventorySLL {

    static Item head = null;

    // Insert at beginning
    static void insertAtBeginning(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);
        newItem.next = head;
        head = newItem;
    }

    // Insert at end
    static void insertAtEnd(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);

        if (head == null) {
            head = newItem;
            return;
        }

        Item temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newItem;
    }

    // Insert at position
    static void insertAtPosition(int id, String name, int qty, double price, int pos) {
        if (pos == 1) {
            insertAtBeginning(id, name, qty, price);
            return;
        }

        Item temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        Item newItem = new Item(id, name, qty, price);
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Delete by ID
    static void deleteById(int id) {
        Item temp = head, prev = null;

        while (temp != null && temp.id != id) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Item not found");
            return;
        }

        if (prev == null)
            head = head.next;
        else
            prev.next = temp.next;

        System.out.println("Item deleted");
    }

    // Update quantity
    static void updateQuantity(int id, int newQty) {
        Item temp = head;

        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    // Search by ID
    static void searchById(int id) {
        Item temp = head;

        while (temp != null) {
            if (temp.id == id) {
                System.out.println(temp.id + " " + temp.name + " " + temp.quantity + " " + temp.price);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    // Search by Name
    static void searchByName(String name) {
        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(temp.id + " " + temp.name + " " + temp.quantity + " " + temp.price);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found");
    }

    // Display items
    static void display() {
        if (head == null) {
            System.out.println("Inventory empty");
            return;
        }

        Item temp = head;
        while (temp != null) {
            System.out.println(temp.id + " " + temp.name + " " + temp.quantity + " " + temp.price);
            temp = temp.next;
        }
    }

    // Total inventory value
    static void totalValue() {
        double total = 0;
        Item temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value = " + total);
    }

    // Merge sort helpers
    static Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Item merge(Item left, Item right, int sortBy, boolean asc) {
        if (left == null) return right;
        if (right == null) return left;

        boolean condition;

        if (sortBy == 1) // sort by name
            condition = asc ? left.name.compareToIgnoreCase(right.name) <= 0
                            : left.name.compareToIgnoreCase(right.name) > 0;
        else // sort by price
            condition = asc ? left.price <= right.price
                            : left.price > right.price;

        Item result;

        if (condition) {
            result = left;
            result.next = merge(left.next, right, sortBy, asc);
        } else {
            result = right;
            result.next = merge(left, right.next, sortBy, asc);
        }

        return result;
    }

    static Item mergeSort(Item head, int sortBy, boolean asc) {
        if (head == null || head.next == null)
            return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, sortBy, asc);
        Item right = mergeSort(nextOfMiddle, sortBy, asc);

        return merge(left, right, sortBy, asc);
    }

    // Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\\n--- Inventory Menu ---");
            System.out.println("1.Insert at Beginning");
            System.out.println("2.Insert at End");
            System.out.println("3.Insert at Position");
            System.out.println("4.Delete by ID");
            System.out.println("5.Update Quantity");
            System.out.println("6.Search by ID");
            System.out.println("7.Search by Name");
            System.out.println("8.Display");
            System.out.println("9.Total Inventory Value");
            System.out.println("10.Sort");
            System.out.println("11.Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 2:
                    insertAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    insertAtPosition(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble(), pos);
                    break;

                case 4:
                    deleteById(sc.nextInt());
                    break;

                case 5:
                    updateQuantity(sc.nextInt(), sc.nextInt());
                    break;

                case 6:
                    searchById(sc.nextInt());
                    break;

                case 7:
                    searchByName(sc.next());
                    break;

                case 8:
                    display();
                    break;

                case 9:
                    totalValue();
                    break;

                case 10:
                    System.out.println("Sort by: 1.Name 2.Price");
                    int sortBy = sc.nextInt();
                    System.out.println("Order: 1.Asc 2.Desc");
                    boolean asc = sc.nextInt() == 1;
                    head = mergeSort(head, sortBy, asc);
                    System.out.println("Sorted");
                    break;

                case 11:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
