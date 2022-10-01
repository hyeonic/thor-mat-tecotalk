package com.example.dummydatagenerator.dao;

import com.example.dummydatagenerator.entity.Crew;
import java.util.List;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CrewDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CrewDao(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void batchInsert(final List<Crew> crews) {
        String sql = "INSERT INTO crew(nickname, track, year)"
                + "VALUES (:nickname, :track, :year) ";

        jdbcTemplate.batchUpdate(sql, SqlParameterSourceUtils.createBatch(crews));
    }
}
