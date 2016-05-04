package com.kwaysetassociativecache.algorithm;

import com.kwaysetassociativecache.BaseTest;
import com.kwaysetassociativecache.stub.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MRUCacheTest extends BaseTest {

    
    @Test
    public void test_mru_cache_size_on_inserts(){

        MRUCache<Long,User> cache = new MRUCache<>(3);
        cache.add(user1.getId(), user1);
        
        assertEquals(Integer.valueOf(1), cache.getCurrentSize());
        
        cache.add(user2.getId(), user2);
        
        assertEquals(Integer.valueOf(2), cache.getCurrentSize());
        
        cache.add(user3.getId(), user3);

        assertEquals(Integer.valueOf(3),cache.getCurrentSize());
        
        cache.add(user4.getId(), user4);

        assertEquals(Integer.valueOf(3), cache.getCurrentSize());

    } 
    
    @Test
    public void test_mru_algorithm_pruning() {

        MRUCache<Long,User> cache = new MRUCache<>(3);
        assertEquals(Integer.valueOf(0), cache.getCurrentSize());

        cache.add(user1.getId(), user1);
        cache.add(user2.getId(), user2);
        cache.add(user3.getId(), user3);
        cache.add(user4.getId(), user4);

        assertEquals(null, cache.get(user3.getId()));

        cache.add(user3.getId(), user3);
        
        assertEquals(null, cache.get(user4.getId()));
        
        cache.get(user1.getId());
        cache.add(user2.getId(), user2);

        assertEquals(null, cache.get(user1.getId()));
        
        cache.add(user4.getId(), user4);
        cache.get(user2.getId());
        cache.add(user1.getId(), user1);

        assertEquals(null, cache.get(user2.getId()));

    }
    
    @Test
    public void test_mru_cache_get_object(){

        MRUCache<Long,User> cache = new MRUCache<>(3);
        cache.add(user1.getId(), user1);
        
        assertEquals(user1,cache.get(user1.getId()));
        
        cache.add(user2.getId(), user2);
        cache.add(user3.getId(), user3);
        
        assertEquals(user2,cache.get(user2.getId()));
        
        cache.add(user4.getId(), user4);
        
        assertEquals(null,cache.get(user2.getId()));
        
    }
    
}
