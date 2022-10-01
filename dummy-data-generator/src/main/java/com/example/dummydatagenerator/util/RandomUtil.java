package com.example.dummydatagenerator.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final int YEAR = 2022;

    public static String generateDate() {
        int month = 1 + RANDOM.nextInt(12); // 1 ~ 12
        int day = 1 + RANDOM.nextInt(28); // 1 ~ 28
        int hour = RANDOM.nextInt(24); // 0 ~ 23
        int minute = RANDOM.nextInt(60); // 0 ~ 59
        int second = RANDOM.nextInt(60); // 0 ~ 59

        return String.format("%s-%s-%s %s:%s:%s", YEAR, month, day, hour, minute, second);
    }
}
