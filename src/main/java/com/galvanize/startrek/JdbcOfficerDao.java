package com.galvanize.startrek;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public List<Officer> findAllOfficers() {
        String sql = "select * from officers";
        return jdbcTemplate.queryForList(sql, Officer.class);
    }

    public Optional<Officer> findOfficerById(Long id) {
        String sql = "select * from officers where id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, Officer.class, id ));
    }
}
