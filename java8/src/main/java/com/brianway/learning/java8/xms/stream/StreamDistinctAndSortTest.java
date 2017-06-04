package com.brianway.learning.java8.xms.stream;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class StreamDistinctAndSortTest {
    public static void main(String[] args) throws Exception {
        // distinct 返回一个具有相同顺序、无重复元素的新流
        Stream<String> uniqueWords = Stream.of("hello", "world", "xms", "xms").distinct();
        uniqueWords.forEach(System.out::println);

        Stream<String> words = WordsUtil.getWords();

        // 按照字符串长度排序
        Stream<String> longestFirst = words.sorted(Comparator.comparing(String::length).reversed());
        longestFirst.forEach(System.out::println);
    }
}
