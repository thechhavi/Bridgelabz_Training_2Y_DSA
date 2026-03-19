
import java.util.*;

class CustomHashMap<K,V>{

    private static class Node<K,V>{
        K key;
        V value;
        Node(K k,V v){ key=k; value=v; }
    }

    private LinkedList<Node<K,V>>[] buckets;
    private int size = 16;

    public CustomHashMap(){
        buckets = new LinkedList[size];
        for(int i=0;i<size;i++) buckets[i] = new LinkedList<>();
    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % size;
    }

    public void put(K key, V value){
        int idx = hash(key);
        for(Node<K,V> node : buckets[idx]){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
        }
        buckets[idx].add(new Node<>(key,value));
    }

    public V get(K key){
        int idx = hash(key);
        for(Node<K,V> node : buckets[idx]){
            if(node.key.equals(key)){
                return node.value;
            }
        }
        return null;
    }

    public void remove(K key){
        int idx = hash(key);
        buckets[idx].removeIf(node -> node.key.equals(key));
    }
}
