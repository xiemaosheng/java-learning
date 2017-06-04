package com.brianway.learning.java8.xms.stream;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class WordsUtil {
    public static Stream<String> getWords()throws Exception{
        String contents = new String(Files.readAllBytes(Paths.get("D://1.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split(","));
        Stream<String> words = wordList.stream();
        return words;
    }
}
