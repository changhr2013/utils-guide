package com.changhr.utils.guava.strings;

import com.google.common.base.Splitter;

import java.util.List;

/**
 * 分词器
 * @author changhr
 * @create 2019-07-30 14:24
 */
public class GuavaSplitterDemo {

    public static void main(String[] args) {
        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().split("foo,bar,  ,,qux"));

        List<String> strings = Splitter.on(";").trimResults().omitEmptyStrings().splitToList("doo;bar;car-dnf;;of;");
        System.out.println(strings);
    }

}
