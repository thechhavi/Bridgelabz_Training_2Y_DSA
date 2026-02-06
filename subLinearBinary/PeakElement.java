public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1,3,20,4,1};
        int l = 0, r = arr.length - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if((mid == 0 || arr[mid] > arr[mid-1]) &&
               (mid == arr.length-1 || arr[mid] > arr[mid+1])) {
                System.out.println(arr[mid]);
                return;
            }
            if(mid > 0 && arr[mid] < arr[mid-1]) r = mid - 1;
            else l = mid + 1;
        }
    }
}