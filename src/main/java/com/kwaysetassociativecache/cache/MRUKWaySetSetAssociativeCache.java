package com.kwaysetassociativecache.cache;

import com.kwaysetassociativecache.KWaySetAssociativeCache;
import com.kwaysetassociativecache.Set;
import com.kwaysetassociativecache.algorithm.MRUCache;
import java.util.ArrayList;
import java.util.List;


public class MRUKWaySetSetAssociativeCache<K,V> extends KWaySetAssociativeCache<K,V> {

        private int nSets;
        private int nWay;

        public MRUKWaySetSetAssociativeCache(int nSets, int nWay){
            this.nSets = nSets;
            this.nWay = nWay;
            this.cache = initialiseCacheSets(nSets, nWay);
        }

        private List<Set<K,V>> initialiseCacheSets(int nSets, int nWay){
            List<Set<K,V>> initialCache = new ArrayList<>(nSets);
            for (int i = 0; i < nSets ; i++) {
                Set<K,V> set = new MRUCache<>(nWay);
                initialCache.add(set);
            }
            return initialCache;
        }

        public Set getSet(K key){
            return cache.get(key.hashCode() % nSets);
        }
}
