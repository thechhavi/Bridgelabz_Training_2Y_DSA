import java.util.*;
public class PositiveNumberDigitSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("size : ");
        int n=sc.nextInt();

        double arr[]= new double[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextDouble();
            if(arr[i]==0) break;
            else if(arr[i]<0) break;

        }

       
      sc.close();

    }
    
}
