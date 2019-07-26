package com.changhr.utils.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * LoadCache 的基本使用
 * @author changhr
 * @create 2019-07-25 15:53
 */
public class CacheDemo1 {

    public static void main(String[] args) {
        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .build(
                        new CacheLoader<String, String>() {
                            @Override
                            public String load(String key) {
                                return key + "value";
                            }

                            @Override
                            public Map<String, String> loadAll(Iterable<? extends String> keys) throws Exception {

                                Map<String, String> cacheMap = new HashMap<>();
                                Iterator<? extends String> iterator = keys.iterator();
                                while (iterator.hasNext()) {
                                    String key = iterator.next();
                                    String value = key + "value";
                                    cacheMap.put(key, value);
                                }
                                return cacheMap;
                            }
                        }
                );

        System.out.println(loadingCache.getUnchecked("111"));

        try {
            loadingCache.getAll(Arrays.asList("1", "2", "3")).forEach((key, value) -> System.out.println(key + " : " + value));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
