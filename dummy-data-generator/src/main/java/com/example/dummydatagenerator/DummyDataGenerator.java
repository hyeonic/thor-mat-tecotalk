package com.example.dummydatagenerator;

import com.example.dummydatagenerator.dao.CrewDao;
import com.example.dummydatagenerator.dao.StudyLogDao;
import com.example.dummydatagenerator.entity.Crew;
import com.example.dummydatagenerator.entity.StudyLog;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DummyDataGenerator implements ApplicationRunner {

    private static final int REPEAT_COUNT = 10;

    private static final int CREW_COUNT = 1_000_000;
    private static final int STUDY_LOG_COUNT = 1_000_000;

    private final CrewDao crewDao;
    private final StudyLogDao studyLogDao;

    public DummyDataGenerator(final CrewDao crewDao, final StudyLogDao studyLogDao) {
        this.crewDao = crewDao;
        this.studyLogDao = studyLogDao;
    }

    @Override
    public void run(final ApplicationArguments args) {
        LocalDateTime before = LocalDateTime.now();
        for (int i = 0; i < REPEAT_COUNT; i++) {
            List<Crew> crews = IntStream.range(0, CREW_COUNT)
                    .mapToObj(ignored -> new Crew())
                    .collect(Collectors.toList());

            crewDao.batchInsert(crews);
        }

        for (int i = 0; i < REPEAT_COUNT; i++) {
            List<StudyLog> studyLogs = IntStream.range(0, STUDY_LOG_COUNT)
                    .mapToObj(ignored -> new StudyLog())
                    .collect(Collectors.toList());

            studyLogDao.batchInsert(studyLogs);
        }

        LocalDateTime after = LocalDateTime.now();
        System.out.println(Duration.between(before, after).toSeconds());
    }
}
