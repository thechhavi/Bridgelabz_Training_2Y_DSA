
import java.util.*;

class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k){
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        int idx = 0;

        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peek() < i-k+1) dq.poll();

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            dq.offer(i);

            if(i>=k-1){
                res[idx++] = nums[dq.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }
}
