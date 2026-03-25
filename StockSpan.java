import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] a = {100,80,60,70,60,75,85};
        int n = a.length;
        Stack<Integer> s = new Stack<>();
        int[] b = new int[n];
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && a[s.peek()]<=a[i]) s.pop();
            b[i] = s.isEmpty()? i+1 : i - s.peek();
            s.push(i);
        }
        System.out.println(Arrays.toString(b));
    }
}