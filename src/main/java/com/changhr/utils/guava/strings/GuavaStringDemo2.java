package com.changhr.utils.guava.strings;

import com.google.common.base.CharMatcher;

import java.util.UUID;

/**
 * 字符串大格式转换
 * @author changhr
 * @create 2019-07-30 10:37
 */
public class GuavaStringDemo2 {

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        String string = CharMatcher.is('-').removeFrom(uuid);
        System.out.println(string);

        String s = CharMatcher.isNot('-').retainFrom(uuid);
        System.out.println(s);

        String s1 = CharMatcher.is('-').replaceFrom(uuid, '_');
        System.out.println(s1);

        String testStr = "--- djalsfj--fasljf   fsldjk-------";
        String s2 = CharMatcher.whitespace().or(CharMatcher.is('-')).removeFrom(testStr);
        System.out.println(s2);
    }
}
