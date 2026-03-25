import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] a = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Deque<Integer> d = new LinkedList<>();
        for(int i=0;i<a.length;i++){
            if(!d.isEmpty() && d.peek()==i-k) d.poll();
            while(!d.isEmpty() && a[d.peekLast()]<a[i]) d.pollLast();
            d.offer(i);
            if(i>=k-1) System.out.print(a[d.peek()]+" ");
        }
    }
}