package com.changhr.utils.jdk.behavior;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author changhr
 * @create 2020-01-20 10:45
 */
@Data
@Accessors(chain = true)
public class Apple {

    private String color;

    private String weight;
}
