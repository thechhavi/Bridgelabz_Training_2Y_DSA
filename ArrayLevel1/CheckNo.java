import java.util.*;
public class CheckNo{
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array");
        int n=sc.nextInt();

        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
             if(arr[i]>0){
                 System.out.println("Positive");
                 if((arr[i]/2)*2==arr[i]) System.out.println("Even");
                 else System.out.println("odd");
             }
            if(arr[i]==0) System.out.println("Zero");
           
            if(arr[i]==0) System.out.print("Negative");

}
sc.close();
}
}
   