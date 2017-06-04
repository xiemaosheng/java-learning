package com.brianway.learning.java8.xms.stream;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class CollectionResultTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "xms");
//        HashSet<String> result = stream.collect(HashSet::new, HashSet::add, HashSet::addAll);
//        result.forEach(System.out::println);

//        List<String> result = stream.collect(Collectors.toList());
//        result.forEach(System.out::println);


//        Set<String> result = stream.collect(Collectors.toSet());
//        result.forEach(System.out::println);

//        TreeSet<String> result = stream.collect(Collectors.toCollection(TreeSet::new));
//        result.forEach(System.out::println);

        String result = stream.collect(Collectors.joining());
        System.out.println(result);


    }

}
