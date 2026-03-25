import java.util.*;
class MyQueue {
    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();
    void enqueue(int x) { a.push(x); }
    int dequeue() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) b.push(a.pop());
        }
        return b.pop();
    }
}