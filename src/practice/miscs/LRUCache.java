package practice.miscs;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
    private Deque<Integer> doublyQueue;

    private HashSet<Integer> hashSet;

    private final int CACHE_SIZE;

    public LRUCache(int CACHE_SIZE) {
        this.doublyQueue = new LinkedList<>();
        this.hashSet = new HashSet<>();
        this.CACHE_SIZE = CACHE_SIZE;
    }

    public void display(){
        Iterator<Integer> itr = doublyQueue.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next() + " ");
        }
    }

    public void refer(int i){
        if(!hashSet.contains(i)){
            if(doublyQueue.size() == CACHE_SIZE){
                int last = doublyQueue.removeLast();
                hashSet.remove(last);
            }
        } else {
            doublyQueue.remove(i);
        }
        doublyQueue.push(i);
        hashSet.add(i);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.refer(1);
        lruCache.refer(2);
        lruCache.refer(3);
        lruCache.refer(2);
        lruCache.refer(5);
        lruCache.display();
    }
}
