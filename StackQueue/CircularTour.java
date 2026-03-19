
class CircularTour {

    static int findStart(int petrol[], int dist[]){
        int start = 0, deficit = 0, capacity = 0;

        for(int i=0;i<petrol.length;i++){
            capacity += petrol[i] - dist[i];

            if(capacity < 0){
                start = i+1;
                deficit += capacity;
                capacity = 0;
            }
        }

        return (capacity + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args){
        int petrol[] = {4,6,7,4};
        int dist[] = {6,5,3,5};
        System.out.println(findStart(petrol,dist));
    }
}
