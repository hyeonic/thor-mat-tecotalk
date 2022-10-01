package com.example.dummydatagenerator.entity;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Track {

    BACKEND(1, "BACKEND"),
    FRONTEND(2, "FRONTEND");

    private final int index;
    private final String value;

    Track(final int index, final String value) {
        this.index = index;
        this.value = value;
    }

    public static Track from(final int index) {
        return Arrays.stream(values())
                .filter(track -> track.index == index)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }
}
