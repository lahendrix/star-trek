package com.galvanize.startrek;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
class JdbcOfficerDao {
    JdbcTemplate jdbcTemplate;

    public JdbcOfficerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer count() {
        String sql = "select count(*) from officers";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
