package com.changhr.utils.jdk.utils;

import lombok.Data;

@Data
// 自定义类
public class SortDTO {
    private String sortTarget;

    public SortDTO(String sortTarget) {
        this.sortTarget = sortTarget;
    }
}