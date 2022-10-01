package com.example.dummydatagenerator.dao;

import com.example.dummydatagenerator.entity.StudyLog;
import java.util.List;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
public class StudyLogDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public StudyLogDao(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(final List<StudyLog> studyLogs) {
        String sql = "INSERT INTO study_log(crew_id, title, content, created_at, updated_at) "
                + "VALUES (:crewId, :title, :content, :createdAt, :updatedAt) ";

        jdbcTemplate.batchUpdate(sql, SqlParameterSourceUtils.createBatch(studyLogs));
    }
}
