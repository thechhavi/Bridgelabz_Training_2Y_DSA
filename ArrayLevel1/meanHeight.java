import java.util.*;
public class meanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array");
        int n=sc.nextInt();

        double arr[]=new double[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextDouble();
        }

        double mean=0;
        for(int i=0;i<n;i++){
            mean=(mean+arr[i]);
        }

        double m=mean/n;
        System.out.println(m);

sc.close();
    }
    
}
