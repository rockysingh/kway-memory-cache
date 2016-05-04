package com.kwaysetassociativecache.algorithm;
import com.kwaysetassociativecache.Set;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends Set<K,V> {

    private int sizeOfCache;
    private static final float loadFactor = 0.75f;

    public LRUCache(int sizeOfCache){
        this.sizeOfCache = sizeOfCache;
        this.set  = new LinkedHashMap<K,V>(sizeOfCache, loadFactor,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
                return size() > LRUCache.this.sizeOfCache;
            }
        };
    }
}
