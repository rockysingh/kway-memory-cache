package com.kwaysetassociativecache.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import com.kwaysetassociativecache.BaseTest;
import com.kwaysetassociativecache.CacheManager;
import com.kwaysetassociativecache.stub.User;
import org.junit.Assert;
import org.junit.Test;

public class LRUCacheMultiThreadTest extends BaseTest {

    private void test(final int threadCount) throws InterruptedException, ExecutionException {
        final CacheManager<Long,User> cacheManager = new CacheManager<>(new LRUKWaySetSetAssociativeCache<>(4,2));
        Callable<Long> task = new Callable<Long>() {
            @Override
            public Long call() {
                users.forEach( user -> {
                            cacheManager.getCache().add(user.getId(), user);
                            cacheManager.getCache().get(user.getId());
                            cacheManager.getCache().remove(user.getId());
                        }
                );
                
                //we are not testing the cache return here hence hard code to user1.getId().
                
                return user1.getId();
            }
        };
        List<Callable<Long>> tasks = Collections.nCopies(threadCount, task);
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<Long>> futures = executorService.invokeAll(tasks);
        List<Long> resultList = new ArrayList<Long>(futures.size());
        for (Future<Long> future : futures) {
            resultList.add(future.get());
        }

        //it should pass unless an exception has been thrown.
        
        Assert.assertEquals(threadCount, futures.size());
        List<Long> expectedList = new ArrayList<Long>(threadCount);
        for (long i = 1; i <= threadCount; i++) {
            expectedList.add(user1.getId());
        }
        Collections.sort(resultList);
        Assert.assertEquals(expectedList, resultList);
    }

    @Test
    public void test_with_one_thread() throws InterruptedException, ExecutionException {
        test(1);
    }

    @Test
    public void test_with_two_threads() throws InterruptedException, ExecutionException {
        test(2);
    }

    @Test
    public void test_with_four_threads() throws InterruptedException, ExecutionException {
        test(4);
    }

    @Test
    public void test_with_eight_threads() throws InterruptedException, ExecutionException {
        test(8);
    }

    @Test
    public void test_with_sixteen_threads() throws InterruptedException, ExecutionException {
        test(16);
    }

    @Test
    public void test_with_thirty_two_threads() throws InterruptedException, ExecutionException {
        test(32);
    }
}