package com.changhr.utils.jdk.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author changhr
 * @create 2020-03-04 14:36
 */
@Slf4j
public class ArraysTest {

    public static void main(String[] args) {

        List<SortDTO> list = ImmutableList.of(
                new SortDTO("300"),
                new SortDTO("50"),
                new SortDTO("200"),
                new SortDTO("220")
        );

        SortDTO[] array = new SortDTO[list.size()];
        list.toArray(array);

        log.info("搜索之前：{}", JSON.toJSONString(array));
        Arrays.sort(array, Comparator.comparing(SortDTO::getSortTarget));
        log.info("先排序，结果为：{}", JSON.toJSONString(array));
        int index = Arrays.binarySearch(array, new SortDTO("200"),
                Comparator.comparing(SortDTO::getSortTarget));
        if(index<0){
            throw new RuntimeException("没有找到 200");
        }
        log.info("搜索结果：{}", JSON.toJSONString(array[index]));
    }

}