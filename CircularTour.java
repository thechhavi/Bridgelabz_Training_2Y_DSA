class Main {
    public static void main(String[] args) {
        int[] petrol = {6,3,7};
        int[] dist = {4,6,3};
        int start=0, extra=0, deficit=0;
        for(int i=0;i<petrol.length;i++){
            extra += petrol[i]-dist[i];
            if(extra<0){
                start=i+1;
                deficit+=extra;
                extra=0;
            }
        }
        System.out.println((extra+deficit>=0)? start : -1);
    }
}