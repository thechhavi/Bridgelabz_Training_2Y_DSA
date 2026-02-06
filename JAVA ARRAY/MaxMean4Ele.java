public class MaxMean4Ele {
    public static void main(String[] args) {
        int arr[]={4,-2,6,-3,-1,4,3,8,1,3,2};
        int k=4;
        int windowSum=0;
        for(int i=0;i<k;i++){
            windowSum += arr[i];
        }
        int max=windowSum;  
        for(int i=k;i<arr.length;i++){
            windowSum=windowSum+arr[i]-arr[i-k];
            if(max<=windowSum) max=windowSum;
        }
        double ans= (max/k);
        System.out.println(ans);

        }
    }