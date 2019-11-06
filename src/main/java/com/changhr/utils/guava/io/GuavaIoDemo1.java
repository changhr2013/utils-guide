package com.changhr.utils.guava.io;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author changhr
 * @create 2019-07-29 14:11
 */
public class GuavaIoDemo1 {

    public static void main(String[] args) throws IOException {

        URL url = GuavaIoDemo1.class.getClassLoader().getResource("test.txt");
        System.out.println(url.getPath());
        File file = new File("C:\\Users\\m4000e\\Desktop\\utils-guide\\src\\main\\resources\\test.txt");
        // 读取一个 UTF-8 编码的文本文件的所有行
        ImmutableList<String> lines = Files.asCharSource(file, Charsets.UTF_8).readLines();
        byte[] read = Files.asByteSource(file).read();

        //统计不同的单词在文件中出现的次数
        HashMultiset<String> wordOccurrences = HashMultiset.create(
                Splitter.on(CharMatcher.whitespace())
                        .trimResults()
                        .omitEmptyStrings()
                        .split(Files.asCharSource(file, Charsets.UTF_8).read())
        );

        for (String wordOccurrence : wordOccurrences) {
            System.out.println(wordOccurrence);
        }

        // 对一个文件进行摘要
        HashCode hash = Files.asByteSource(file).hash(Hashing.sha256());
        System.out.println(hash);

        // 从一个URL拷贝数据到文件
//        Resources.asByteSource(new URL("http://www.baidu.com")).copyTo(Files.asByteSink(file));

    }
}
