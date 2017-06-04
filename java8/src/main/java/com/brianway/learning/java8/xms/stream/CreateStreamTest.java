package com.brianway.learning.java8.xms.stream;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class CreateStreamTest {
    public static void main(String[] args) {
        // 创建Stream对象方式1
        Stream<String> song = Stream.of("hello","world","the","nice","social");
        song.forEach(System.out::println);

        // 创建Stream对象方式2:创建一个空对象
        Stream<String> silence = Stream.empty();

        // 创建非空对象Stream
        Stream<String> echos =Stream.generate(() -> "Echo");
//        echos.forEach(System.out::println);

        Stream<Double> randoms = Stream.generate(Math::random);
//        randoms.forEach(System.out::println);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO,n -> n.add(BigInteger.ONE));
        integers.forEach(System.out::println);
    }
}
