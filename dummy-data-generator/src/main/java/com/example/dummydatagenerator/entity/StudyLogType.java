package com.example.dummydatagenerator.entity;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum StudyLogType {

    SHARE(1, "SHARE"),
    QUESTION(2, "QUESTION");

    private final int index;
    private final String value;

    StudyLogType(final int index, final String value) {
        this.index = index;
        this.value = value;
    }

    public static StudyLogType from(final int index) {
        return Arrays.stream(values())
                .filter(studyLogType -> studyLogType.index == index)
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
