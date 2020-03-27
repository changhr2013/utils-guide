package com.changhr.utils.jdk.optional;

import java.util.Optional;

/**
 * @author changhr
 * @create 2020-01-19 14:12
 */
public class OptionalTest {

    public static void main(String[] args) {
        String unknown = Optional.ofNullable("null")
                .map(value -> value.getClass().getName())
                .orElse("unknown");
        System.out.println(unknown);
    }

}
