// need to complet the code


import java.util.*;
public class Main {

    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;
            public Node(K key,V value){
                this.key = key;
                this.value = value;
            }

        }
        private int size;//n
        private LinkedList<Node> buckets[]; //N bucket.length

        //@SuppressWarnings("unchecked");
        public HashMap(){
            this.size = 4;
            this.buckets = new LinkedList[4];
           for(int i = 0;i < 4;i++){
               this.buckets[i] = new LinkedList<>();
           }

        }
        private int HashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc)%size;

        }
        public void put(K key,V value){
            int bi = HashFunction(key);
            int di = SearchInLL(key);

        }


    }

    public static void main(String[] args) {

    }
}
