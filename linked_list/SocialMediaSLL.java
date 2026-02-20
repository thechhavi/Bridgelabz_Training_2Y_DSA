import java.util.Scanner;

// Friend node
class Friend {
    int id;
    Friend next;

    Friend(int id) {
        this.id = id;
        this.next = null;
    }
}

// User node
class User {
    int id, age;
    String name;
    Friend friendHead;
    User next;

    User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.friendHead = null;
        this.next = null;
    }
}

public class SocialMediaSLL {

    static User head = null;

    // Add user
    static void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Find user by ID
    static User findUser(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.id == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend ID to friend list
    static void addFriendNode(User user, int friendId) {
        Friend newFriend = new Friend(friendId);
        newFriend.next = user.friendHead;
        user.friendHead = newFriend;
    }

    // Add friend connection (bidirectional)
    static void addFriend(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        addFriendNode(u1, id2);
        addFriendNode(u2, id1);

        System.out.println("Friend added");
    }

    // Remove friend node
    static void removeFriendNode(User user, int friendId) {
        Friend temp = user.friendHead, prev = null;

        while (temp != null && temp.id != friendId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        if (prev == null)
            user.friendHead = temp.next;
        else
            prev.next = temp.next;
    }

    // Remove friend connection
    static void removeFriend(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        removeFriendNode(u1, id2);
        removeFriendNode(u2, id1);

        System.out.println("Friend removed");
    }

    // Display friends of a user
    static void displayFriends(int id) {
        User user = findUser(id);

        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Friends of " + user.name + ": ");

        Friend temp = user.friendHead;
        if (temp == null) {
            System.out.println("No friends");
            return;
        }

        while (temp != null) {
            System.out.print(temp.id + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Count friends
    static void countFriends(int id) {
        User user = findUser(id);

        if (user == null) {
            System.out.println("User not found");
            return;
        }

        int count = 0;
        Friend temp = user.friendHead;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total friends = " + count);
    }

    // Search user by name
    static void searchByName(String name) {
        User temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(temp.id + " " + temp.name + " " + temp.age);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("User not found");
    }

    // Mutual friends
    static void mutualFriends(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Mutual Friends: ");
        boolean found = false;

        Friend f1 = u1.friendHead;

        while (f1 != null) {
            Friend f2 = u2.friendHead;

            while (f2 != null) {
                if (f1.id == f2.id) {
                    System.out.print(f1.id + " ");
                    found = true;
                }
                f2 = f2.next;
            }

            f1 = f1.next;
        }

        if (!found)
            System.out.println("None");
        else
            System.out.println();
    }

    // Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\\n--- Social Media Menu ---");
            System.out.println("1.Add User");
            System.out.println("2.Add Friend");
            System.out.println("3.Remove Friend");
            System.out.println("4.Display Friends");
            System.out.println("5.Mutual Friends");
            System.out.println("6.Search by Name");
            System.out.println("7.Count Friends");
            System.out.println("8.Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addUser(sc.nextInt(), sc.next(), sc.nextInt());
                    break;

                case 2:
                    addFriend(sc.nextInt(), sc.nextInt());
                    break;

                case 3:
                    removeFriend(sc.nextInt(), sc.nextInt());
                    break;

                case 4:
                    displayFriends(sc.nextInt());
                    break;

                case 5:
                    mutualFriends(sc.nextInt(), sc.nextInt());
                    break;

                case 6:
                    searchByName(sc.next());
                    break;

                case 7:
                    countFriends(sc.nextInt());
                    break;

                case 8:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
