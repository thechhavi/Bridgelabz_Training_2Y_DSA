import java.util.*;
class Main {
    static void insert(Stack<Integer> a, int x) {
        if (a.isEmpty() || a.peek() <= x) { a.push(x); return; }
        int y = a.pop();
        insert(a, x);
        a.push(y);
    }
    static void sort(Stack<Integer> a) {
        if (!a.isEmpty()) {
            int x = a.pop();
            sort(a);
            insert(a, x);
        }
    }
}