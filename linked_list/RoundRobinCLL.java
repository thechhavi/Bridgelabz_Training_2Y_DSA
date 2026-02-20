import java.util.Scanner;

class Process {
    int id, burst, remaining, priority;
    int completionTime, waitingTime, turnaroundTime;
    Process next;

    Process(int id, int burst, int priority) {
        this.id = id;
        this.burst = burst;
        this.remaining = burst;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinCLL {

    static Process head = null;

    // Insert at end (circular)
    static void addProcess(int id, int burst, int priority) {
        Process newProcess = new Process(id, burst, priority);

        if (head == null) {
            head = newProcess;
            newProcess.next = head;
            return;
        }

        Process temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newProcess;
        newProcess.next = head;
    }

    // Display queue
    static void displayQueue() {
        if (head == null) {
            System.out.println("Queue empty");
            return;
        }

        Process temp = head;
        do {
            System.out.println("P" + temp.id + " BT:" + temp.remaining);
            temp = temp.next;
        } while (temp != head);
    }

    // Remove process
    static void deleteProcess(Process target) {
        if (head == null) return;

        Process temp = head, prev = null;

        // If only one process
        if (head == target && head.next == head) {
            head = null;
            return;
        }

        // If head to delete
        if (head == target) {
            Process last = head;
            while (last.next != head)
                last = last.next;

            head = head.next;
            last.next = head;
            return;
        }

        do {
            prev = temp;
            temp = temp.next;
            if (temp == target) {
                prev.next = temp.next;
                return;
            }
        } while (temp != head);
    }

    // Round Robin scheduling
    static void roundRobin(int quantum) {
        if (head == null) {
            System.out.println("No processes");
            return;
        }

        int time = 0;
        int totalWT = 0, totalTAT = 0;
        int count = 0;

        Process temp = head;

        while (head != null) {

            temp = head;

            do {
                if (temp.remaining > 0) {

                    if (temp.remaining > quantum) {
                        time += quantum;
                        temp.remaining -= quantum;
                    } else {
                        time += temp.remaining;
                        temp.remaining = 0;

                        temp.completionTime = time;
                        temp.turnaroundTime = temp.completionTime;
                        temp.waitingTime = temp.turnaroundTime - temp.burst;

                        totalWT += temp.waitingTime;
                        totalTAT += temp.turnaroundTime;
                        count++;

                        Process toDelete = temp;
                        temp = temp.next;
                        deleteProcess(toDelete);

                        if (head == null)
                            break;

                        continue;
                    }
                }

                temp = temp.next;

            } while (temp != head);

            System.out.println("\\nQueue after round:");
            displayQueue();
        }

        System.out.println("\\nAverage Waiting Time = " + (double) totalWT / count);
        System.out.println("Average Turnaround Time = " + (double) totalTAT / count);
    }

    // Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\\n--- Round Robin Menu ---");
            System.out.println("1.Add Process");
            System.out.println("2.Display Queue");
            System.out.println("3.Execute Round Robin");
            System.out.println("4.Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID BurstTime Priority: ");
                    addProcess(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;

                case 2:
                    displayQueue();
                    break;

                case 3:
                    System.out.print("Enter Time Quantum: ");
                    roundRobin(sc.nextInt());
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
