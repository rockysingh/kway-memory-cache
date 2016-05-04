package com.kwaysetassociativecache.algorithm;

import com.kwaysetassociativecache.Set;
import java.util.LinkedHashMap;

public class MRUCache<K,V> extends Set<K,V> {

    private int sizeOfCache;
    private static final float loadFactor = 0.75f;
    private K last;

    public MRUCache(int sizeOfCache){
        this.sizeOfCache = sizeOfCache;
        this.set = new LinkedHashMap<K,V>(sizeOfCache, loadFactor,true);
    }
    
    public V get(K key){
        V value = set.get(key);
        if (value != null) {
            last = key;
        }
        return value;
    }

    public void add(K key, V value){
        if (getCurrentSize() >= sizeOfCache) {
            if (last != null) {
                remove(last);
            }
        }
        set.put(key,value);
        last = key;
    }
    
}
