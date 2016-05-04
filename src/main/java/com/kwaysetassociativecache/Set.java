package com.kwaysetassociativecache;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class Set<K,V> {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock read = lock.readLock();
    private final Lock write = lock.writeLock();
    protected Map<K,V> set;

    public Lock getReadLock(){
        return read;
    }
    
    public Lock getWriteLock(){
        return write;
    }

    public void add(K key,V value) {
        set.put(key,value);
    }
    
    public void remove(K key) {
        set.remove(key);
    }
    public V get(K key) {
        return set.get(key);
    }
    
    public Integer getCurrentSize() {
        return set.size();
    }
    
    public void empty() {
        set.clear();
    }
    
}
