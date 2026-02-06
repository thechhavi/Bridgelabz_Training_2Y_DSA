import java.util.*;
public class voteEligibility{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array");
        int n=sc.nextInt();

        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
            if(arr[i]<0) System.out.println("invalid age");
            else if(arr[i]<18) System.out.println("Not eligible");
            else System.out.println("eligible");
        }
        sc.close();
    }
}