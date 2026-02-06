import java.util.*;
public class multiFrom6to9 {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
   
        int in=0;
        for(int i=6;i<=9;i++){
            arr[in]=n*i;
            in++;
        }
         int index = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(n + " * " + i + " = " + arr[index]);
            index++;
        }
        sc.close();



    }
}
