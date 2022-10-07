package com.example.dummydatagenerator.dao;

import com.example.dummydatagenerator.entity.StudyLog;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudyLogDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final JdbcTemplate template;

    public StudyLogDao(final NamedParameterJdbcTemplate jdbcTemplate, final JdbcTemplate template) {
        this.jdbcTemplate = jdbcTemplate;
        this.template = template;
    }

    @Transactional
    public void batchInsert(final List<StudyLog> studyLogs) {
        template.update("SET foreign_key_checks = 0");
        String sql = "INSERT INTO study_log(crew_id, title, content, type, created_at, updated_at) "
                + "VALUES (:crewId, :title, :content, :type, :createdAt, :updatedAt) ";

        jdbcTemplate.batchUpdate(sql, SqlParameterSourceUtils.createBatch(studyLogs));
        template.update("SET foreign_key_checks = 1");
    }
}
