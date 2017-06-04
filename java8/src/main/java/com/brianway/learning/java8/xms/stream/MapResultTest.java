package com.brianway.learning.java8.xms.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class MapResultTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("1","xms1");
        Person p2 = new Person("2","xms2");
        Person p3 = new Person("3","xms3");
        Person p4 = new Person("4","xms4");
        Person p5 = new Person("5","xms5");
        Person p6 = new Person("6","xms6");
        Person p7 = new Person("7","xms7");

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p7);

//        Stream<Person> personStream = Stream.of(p1,p2,p3,p4,p5,p6,p7);
        Stream<Person> personStream = list.stream();
        Map<String,String> idToName = personStream.collect(Collectors.toMap(Person::getId,Person::getName));
        idToName.forEach((id,name) -> System.out.println(name));

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String,String> languageNames = locales.collect(Collectors.toMap(
                l -> l.getDisplayCountry(),
                l -> l.getDisplayCountry(l),
                (existingValue,newValue) -> existingValue
        ));
        languageNames.forEach((key,value) -> System.out.println(value));

        Map<String,Set<String>> countryLanguageSets = locales.collect(Collectors.toMap(
           l -> l.getDisplayCountry(),
           l -> Collections.singleton(l.getDisplayCountry(l)),
                (key,value) ->{
                    Set<String> r = new HashSet<String>(key);
                    r.addAll(value);
                    return value;
                }
        ));

        countryLanguageSets.forEach((key,value) -> System.out.println(value));

        Map<String,Person> idToPerson = personStream.collect(Collectors.toMap(
           Person::getId,
           Function.identity(),
                (existingValue,newValue) -> {
                    throw new IllegalStateException("存在相同的对象");
                },
                TreeMap::new
        ));

        idToPerson.forEach((key,value) -> System.out.println(value));
    }
}
