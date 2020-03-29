// concurrent/ParallelPrime.java
package com.changhr.utils.concurrent.onjava.stream;

import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;

import org.springframework.util.StopWatch;

public class ParallelPrime {
    static final int COUNT = 100_000;

    public static boolean isPrime(long n) {
        return LongStream.rangeClosed(2, (long) Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }

    public static void main(String[] args)
            throws IOException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<String> primes =
                LongStream.iterate(2, i -> i + 1)
                        .parallel()              // [1]
                        .filter(ParallelPrime::isPrime)
                        .limit(COUNT)
                        .mapToObj(Long::toString)
                        .collect(Collectors.toList());
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        Files.write(Paths.get("primes.txt"), primes, StandardOpenOption.CREATE);
    }
}