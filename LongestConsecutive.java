import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] a={100,4,200,1,3,2};
        HashSet<Integer> s=new HashSet<>();
        for(int x:a) s.add(x);
        int max=0;
        for(int x:s){
            if(!s.contains(x-1)){
                int y=x,count=1;
                while(s.contains(y+1)){ y++; count++; }
                max=Math.max(max,count);
            }
        }
        System.out.println(max);
    }
}