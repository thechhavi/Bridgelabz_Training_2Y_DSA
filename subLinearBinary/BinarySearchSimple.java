public class BinarySearchSimple {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int target = 4;
        int l = 0, r = arr.length - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] == target) {
                System.out.println(mid);
                return;
            }
            if(arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        System.out.println(-1);
    }
}