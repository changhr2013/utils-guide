package com.changhr.utils.custom.jdk;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author changhr
 * @create 2019-08-02 16:17
 */
public class FinallyDemo {

    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(test1());
        System.out.println(test3());
        System.out.println(test2());
    }

    public static int test() {
        int x = 1;
        try{
            return x;
        }finally {
            ++x;
        }
    }

    public static Map<Integer, Integer> test1() {
        Map<Integer, Integer> resultMap = Maps.newHashMap();
        Map<Integer, Integer> resultMap2 = Maps.newHashMap();
        resultMap2.put(3,5);
        resultMap2.put(5,7);
        try{
            return resultMap;
        }finally {
            resultMap = resultMap2;
        }
    }

    public static Map<Integer, Integer> test3() {
        Map<Integer, Integer> resultMap = Maps.newHashMap();
        try{
            return resultMap;
        }finally {
            resultMap.put(1, 2);
            resultMap.put(2, 4);
        }
    }

    public static int test2() {
        try{
            return 1;
        }finally {
            return 2;
        }
    }
}
