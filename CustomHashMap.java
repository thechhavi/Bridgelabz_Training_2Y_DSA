import java.util.*;
class MyMap {
    LinkedList<int[]>[] a = new LinkedList[10];
    MyMap(){
        for(int i=0;i<10;i++) a[i]=new LinkedList<>();
    }
    int hash(int key){ return key%10; }
    void put(int key,int val){
        int i=hash(key);
        for(int[] x:a[i]){
            if(x[0]==key){ x[1]=val; return; }
        }
        a[i].add(new int[]{key,val});
    }
    int get(int key){
        int i=hash(key);
        for(int[] x:a[i]) if(x[0]==key) return x[1];
        return -1;
    }
}