package com.changhr.utils.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.Weigher;
import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ExecutionException;

/**
 * 基于容量的缓存回收
 *
 * @author changhr
 * @create 2019-07-26 16:05
 */
public class CacheDemo3 {

    public static LoadingCache<String, String> loadingCache;

    static {
        loadingCache = (LoadingCache<String, String>) CacheBuilder.newBuilder()
                .maximumWeight(100000)
                .weigher(new Weigher<String, String>() {
                    @Override
                    public int weigh(String key, String value) {
                        return value.length();
                    }
                })
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return key + Long.toBinaryString(RandomUtils.nextLong());

                    }
                });
    }

    public static void main(String[] args) {
        try {
            System.out.println(loadingCache.get("No1."));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
