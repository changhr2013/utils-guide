package com.changhr.utils.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Cache 中 Callable 的使用
 * @author changhr
 * @create 2019-07-25 15:53
 */
public class CacheDemo2 {

    public static void main(String[] args) {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .build();

        try{
            // 如果有缓存则返回，否则运算，缓存，然后返回
            String value = cache.get("123", new Callable<String>() {
                @Override
                public String call() throws Exception {
                    if (true){
                        throw new Exception("数据库查询异常");
                    }
                    return "123" + "value";
                }
            });
            System.out.println(value);
        }catch (ExecutionException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
    }

}
