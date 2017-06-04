package com.brianway.learning.java8.xms.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class FilterAndFilterMapTest {
    public static void main(String[] args) throws Exception{
        Stream<String> words = WordsUtil.getWords();
//        Stream<String> lowercaseWords = words.map(String::toLowerCase);
//        lowercaseWords.forEach(System.out::println);

//        Stream<Character> firstChars = words.map(s -> s.charAt(0));
//        firstChars.forEach(System.out::println);

//        Stream<Stream<Character>> result = words.map(w -> characterStream(w));
//        result.forEach(System.out::println);

        Stream<Character> letters = words.flatMap(w -> characterStream(w)).limit(10);
        letters.forEach(System.out::println);
    }

    /**
     * 返回值包含多个值的stream流
     * @param s
     * @return
     */
    private static Stream<Character> characterStream(String s){
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()){
            result.add(c);
        }
        return result.stream();
    }
}
