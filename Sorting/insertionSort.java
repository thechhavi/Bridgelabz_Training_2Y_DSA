public class insertionSort 
{
    public static void main(String[] args) {
        int[] arr={9,8,7,6,5,4};

        for(int i=1;i<arr.length; i++){
            int j =i-1;
            int temp=arr[i];
            while(j>=0 && arr[j] >temp){
                arr[j+1]= arr[j];
                j--;
            }
            arr[j+1]= temp;
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    
}