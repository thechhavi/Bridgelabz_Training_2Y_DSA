import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] a = {1,-1,2,-2,3};
        int sum=0;
        HashMap<Integer,Integer> m = new HashMap<>();
        m.put(0,1);
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            if(m.containsKey(sum)) System.out.println("Zero sum subarray found");
            m.put(sum,m.getOrDefault(sum,0)+1);
        }
    }
}