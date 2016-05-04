package com.kwaysetassociativecache.cache;

import com.kwaysetassociativecache.BaseTest;
import com.kwaysetassociativecache.CacheManager;
import com.kwaysetassociativecache.stub.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MRUKWaySetAssociativeCacheTest extends BaseTest {


    @Test
    public void test_mru_insert_and_retrieve_on_direct_mapped(){
        CacheManager<Long,User> cacheManager = new CacheManager<>(new MRUKWaySetSetAssociativeCache<>(8,1));

        cacheManager.getCache().add(user1.getId(), user1);

        assertEquals(user1, cacheManager.getCache().get(user1.getId()));

        cacheManager.getCache().add(user2.getId(), user2);

        assertEquals(user2, cacheManager.getCache().get(user2.getId()));

        cacheManager.getCache().add(user3.getId(), user3);

        assertEquals(user3, cacheManager.getCache().get(user3.getId()));

        cacheManager.getCache().add(user4.getId(), user4);

        assertEquals(user4, cacheManager.getCache().get(user4.getId()));

        cacheManager.getCache().remove(user4.getId());

        assertEquals(null,cacheManager.getCache().get(user4.getId()));

    }
    
    @Test
    public void test_mru_insert_and_retrieve_on_2_way_set_associative_cache(){


        CacheManager<Long,User> cacheManager = new CacheManager<>(new MRUKWaySetSetAssociativeCache<>(4,2));

        cacheManager.getCache().add(user1.getId(), user1);

        assertEquals(user1, cacheManager.getCache().get(user1.getId()));

        cacheManager.getCache().add(user2.getId(), user2);

        assertEquals(user2, cacheManager.getCache().get(user2.getId()));

        cacheManager.getCache().add(user3.getId(), user3);

        assertEquals(user3, cacheManager.getCache().get(user3.getId()));

        cacheManager.getCache().add(user4.getId(), user4);

        assertEquals(user4, cacheManager.getCache().get(user4.getId()));

        cacheManager.getCache().remove(user4.getId());

        assertEquals(null,cacheManager.getCache().get(user4.getId()));

    }

    @Test
    public void test_mru_insert_and_retrieve_on_4_way_set_associative_cache(){


        CacheManager<Long,User> cacheManager = new CacheManager<>(new MRUKWaySetSetAssociativeCache<>(2,4));

        cacheManager.getCache().add(user1.getId(), user1);

        assertEquals(user1, cacheManager.getCache().get(user1.getId()));

        cacheManager.getCache().add(user2.getId(), user2);

        assertEquals(user2, cacheManager.getCache().get(user2.getId()));

        cacheManager.getCache().add(user3.getId(), user3);

        assertEquals(user3, cacheManager.getCache().get(user3.getId()));

        cacheManager.getCache().add(user4.getId(), user4);

        assertEquals(user4, cacheManager.getCache().get(user4.getId()));

        cacheManager.getCache().remove(user4.getId());

        assertEquals(null,cacheManager.getCache().get(user4.getId()));

    }

    @Test
    public void test_mru_insert_and_retrieve_on_fully_associative(){


        CacheManager<Long,User> cacheManager = new CacheManager<>(new MRUKWaySetSetAssociativeCache<>(1,8));

        cacheManager.getCache().add(user1.getId(), user1);

        assertEquals(user1, cacheManager.getCache().get(user1.getId()));

        cacheManager.getCache().add(user2.getId(), user2);

        assertEquals(user2, cacheManager.getCache().get(user2.getId()));

        cacheManager.getCache().add(user3.getId(), user3);

        assertEquals(user3, cacheManager.getCache().get(user3.getId()));

        cacheManager.getCache().add(user4.getId(), user4);

        assertEquals(user4, cacheManager.getCache().get(user4.getId()));

        cacheManager.getCache().remove(user4.getId());

        assertEquals(null,cacheManager.getCache().get(user4.getId()));

    }



}
