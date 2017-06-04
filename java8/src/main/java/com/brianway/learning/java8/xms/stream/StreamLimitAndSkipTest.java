package com.brianway.learning.java8.xms.stream;

import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class StreamLimitAndSkipTest {
    public static void main(String[] args) throws Throwable{

        Stream<String> words = WordsUtil.getWords();
        // 限制子流长度
//        Stream<Double> randoms = Stream.generate(Math::random).limit(10);
//        randoms.forEach(System.out::println);

        // 丢弃前面N个元素
        Stream<String> wordSkip = words.skip(1000);
        wordSkip.forEach(System.out::println);
    }
}
