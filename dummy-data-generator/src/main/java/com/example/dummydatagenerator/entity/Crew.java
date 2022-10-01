package com.example.dummydatagenerator.entity;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Crew {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private final String nickname;
    private final String track;
    private final int year;

    public Crew() {
        String uuid = UUID.randomUUID().toString();
        this.nickname = uuid.substring(0, 8);
        int index = 1 + RANDOM.nextInt(2); // 1 ~ 2
        this.track = Track.from(index).getValue();
        this.year = 1 + RANDOM.nextInt(4); // 1 ~ 4
    }

    public String getNickname() {
        return nickname;
    }

    public String getTrack() {
        return track;
    }

    public int getYear() {
        return year;
    }
}
