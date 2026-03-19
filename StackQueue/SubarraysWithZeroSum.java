
import java.util.*;

class SubarraysWithZeroSum {

    static int countZeroSum(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0, count = 0;

        for(int x : arr){
            sum += x;

            if(sum == 0) count++;

            if(map.containsKey(sum)){
                count += map.get(sum);
            }

            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        return count;
    }

    public static void main(String[] args){
        int[] arr = {6,-1,-3,4,-2,2,4,6,-12,-7};
        System.out.println(countZeroSum(arr));
    }
}
