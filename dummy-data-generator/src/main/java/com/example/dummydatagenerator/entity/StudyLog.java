package com.example.dummydatagenerator.entity;

import com.example.dummydatagenerator.util.RandomUtil;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class StudyLog {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private Long crewId;
    private String title;
    private String content;
    private String type;
    private String createdAt;
    private String updatedAt;

    public StudyLog(final int crewIdRange) {
        this.crewId = 1 + RANDOM.nextLong(crewIdRange);
        String uuid = UUID.randomUUID().toString();
        this.title = uuid.substring(0, 8);
        this.content = uuid;

        int index = 1 + RANDOM.nextInt(2); // 1 ~ 2
        this.type = StudyLogType.from(index).getValue();

        String dateTime = RandomUtil.generateDate();
        this.createdAt = dateTime;
        this.updatedAt = dateTime;
    }

    public Long getCrewId() {
        return crewId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
