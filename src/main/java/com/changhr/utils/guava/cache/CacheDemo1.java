package com.changhr.utils.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
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
                        }
                );

        System.out.println(loadingCache.getUnchecked("111"));
    }

}
