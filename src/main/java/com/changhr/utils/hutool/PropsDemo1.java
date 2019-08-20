package com.changhr.utils.hutool;

import cn.hutool.setting.dialect.Props;

/**
 * @author changhr
 * @create 2019-07-29 16:31
 */
public class PropsDemo1 {

    public static void main(String[] args) {
        Props props = new Props("application.properties");
        System.out.println(props.getStr("one"));

        Integer two = props.getInt("two");
        System.out.println(two);

        System.out.println(props.getStr("three"));
    }

}
