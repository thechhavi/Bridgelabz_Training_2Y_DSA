public class quickSortJava {
static void main(String[] args) {
int[] arr = {4,6,2,5,7,9,1,3};
quickSort(arr, 0, arr.length-1);
for (int ele : arr){
System.out.print(ele + " ");
}
}

public static void quickSort(int[] arr, int low, int high){
if(low <= high){
int pivotIndex = partition(arr, low, high);
quickSort(arr, 0, pivotIndex-1);
quickSort(arr, pivotIndex + 1, high);
}
}

public static void swap(int[] arr, int i, int j){
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
}

public static int partition(int[] arr, int low, int high){
int i = low+1;
int j = high;
int pivotElement = arr[low];
while(i <= j) {
while (pivotElement >= arr[i] && i <= high ) {
i++;
}

while (pivotElement < arr[j] && j >= low) {
j--;
}

if (i < j) {
swap(arr, i, j);
}
}
swap(arr, low, j);
return j;
}
}
