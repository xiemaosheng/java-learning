package com.brianway.learning.java8.xms.stream;

import org.springframework.cglib.core.Local;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class MapGroupTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("1", "xms1");
        Person p2 = new Person("2", "xms2");
        Person p3 = new Person("3", "xms3");
        Person p4 = new Person("4", "xms4");
        Person p5 = new Person("5", "xms5");
        Person p6 = new Person("6", "xms6");
        Person p7 = new Person("7", "xms7");

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        Stream<Person> personStream = list.stream();


        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        // 分组函数，非静态方法不能运行，仅仅示例
//        Map<String,List<Local>> countryToLocales = locales.collect(Collectors.groupingBy(Locale::getCountry,Collectors.toSet()));

        Map<String, Long> countryToLocaleCounts = locales.collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
//        countryToLocaleCounts.forEach((key,value) -> System.out.println(key+":"+value));

//        Map<String, Optional<String>> stateToLongestPersonName = personStream.collect(
//                Collectors.groupingBy(Person::getId, Collectors.mapping(Person::getName, Collectors.maxBy(String::length))));
    }
}
