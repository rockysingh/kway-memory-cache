package com.kwaysetassociativecache;

public class CacheManager<K,V> {

    private KWaySetAssociativeCache<K,V> cache;

    public CacheManager(KWaySetAssociativeCache<K, V> cache){
        this.cache = cache;
    }

    public KWaySetAssociativeCache<K, V> getCache() {
        return cache;
    }
}