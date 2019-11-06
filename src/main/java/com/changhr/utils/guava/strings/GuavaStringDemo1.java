package com.changhr.utils.guava.strings;

import com.google.common.base.CaseFormat;

/**
 * 字符串大小写格式转换
 * @author changhr
 * @create 2019-07-30 10:37
 */
public class GuavaStringDemo1 {

    public static void main(String[] args) {
        String lowerCamel = "testBaseContent";
        String upperCamel = "TestBaseContent";
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, lowerCamel));
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, lowerCamel));

        System.out.println(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, upperCamel));
        System.out.println(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, upperCamel));
        System.out.println(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, upperCamel));
    }
}
