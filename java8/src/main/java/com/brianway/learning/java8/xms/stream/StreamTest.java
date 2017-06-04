package com.brianway.learning.java8.xms.stream;

import org.springframework.util.StopWatch;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class StreamTest {
    public static void main(String[] args) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("D://1.txt")), StandardCharsets.UTF_8);
            List<String> words = Arrays.asList(contents.split(","));

            // 并行计算
            StopWatch watch1 = new StopWatch();
            watch1.start();
            long count1 = words.parallelStream().filter(w -> w.length() > 10).count();
            watch1.stop();
            System.out.println(count1 + "花费时间：" + watch1.getLastTaskTimeMillis());

            // 非并行计算
            StopWatch watch = new StopWatch();
            watch.start();
            long count = words.stream().filter(w -> w.length() > 10).count();
            watch.stop();
            System.out.println(count+"花费时间：" + watch.getLastTaskTimeMillis());

            // 其实感觉花费时间差不了多少，是数据量太小了吗？


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
