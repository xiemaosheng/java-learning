package com.brianway.learning.java8.xms.stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class StreamOptionalTest {
    public static void main(String[] args) throws Exception {
        Stream<String> words = WordsUtil.getWords();

        // 获取流中最大值
//        Optional<String> largest = words.max(String::compareToIgnoreCase);
//        if (largest.isPresent()) {
//            System.out.println("largest:" + largest.get());
//        }

        Stream<Integer> integerStream = Stream.of(11,55, 99, 77, 66, 12, 45, 68);
        Optional<Integer> maxInteger = integerStream.max(Integer::compareTo);
        if (maxInteger.isPresent()) {
            System.out.println("Integer max:" + maxInteger.get());
        }

//        Optional<String> startWithQ = words.filter(s -> s.startsWith("B")).findFirst();
//        if (startWithQ.isPresent()){
//            System.out.println("letter : " + startWithQ.get());
//        }

        boolean aWordStartsWithQ = words.parallel().anyMatch(s -> s.startsWith("18"));
        System.out.println(aWordStartsWithQ);

    }
}
