package com.brianway.learning.java8.xms.stream;

import java.util.Optional;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class OptionalFlapMapTest {
    public static void main(String[] args) {
    }

    private static Optional<Double> squareRoot(Double x){
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}
