import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] a={2,7,11,15};
        int target=9;
        HashSet<Integer> s=new HashSet<>();
        for(int x:a){
            if(s.contains(target-x)){
                System.out.println("Pair found");
                return;
            }
            s.add(x);
        }
        System.out.println("No pair");
    }
}