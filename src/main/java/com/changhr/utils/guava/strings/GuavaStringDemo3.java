package com.changhr.utils.guava.strings;

import com.google.common.base.Joiner;

import java.util.Arrays;

/**
 * 字符串插入器
 * @author changhr
 * @create 2019-07-30 14:19
 */
public class GuavaStringDemo3 {

    private static final Joiner joiner = Joiner.on(";").useForNull("null");
    private static final Joiner skipNullJoiner = Joiner.on(";").skipNulls();

    public static void main(String[] args) {
        System.out.println(joiner.join("123", "abc", null, "xyz", 678));
        System.out.println(skipNullJoiner.join("123", "abc", null, "xyz", 678));

        System.out.println(Joiner.on(",").join(Arrays.asList("1", "2", "3")));
    }

}
