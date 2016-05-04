package com.kwaysetassociativecache;

import java.util.List;

public abstract class KWaySetAssociativeCache<K,V> {
    
    protected List<Set<K,V>> cache;
    
    abstract public Set<K,V> getSet(K key);

    public V get(K key) {
        Set<K,V> set = getSet(key);
        set.getReadLock().lock();
        try {
            return set.get(key);
        } finally {
            set.getReadLock().unlock();
        }
    }

    public void add(K key, V value) {
        Set<K,V> set = getSet(key);
        set.getWriteLock().lock();
        try {
            set.add(key,value);
        } finally {
            set.getWriteLock().unlock();
        }
    }

    public void remove(K key){
        Set<K,V> set = getSet(key);
        set.getWriteLock().lock();
        try {
            set.remove(key);
        } finally {
            set.getWriteLock().unlock();
        }
    }

}
