package com.galvanize.startrek;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class JdbcOfficerDaoTest {
    JdbcOfficerDao jdbcOfficerDao;

    @Mock
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcOfficerDao = new JdbcOfficerDao(jdbcTemplate);
    }

    @Test
    void countOfficers() {
        //Setup
        String sql = "select * from officers";
        List officers = new ArrayList<Officer>();
        int expected = 5;

        for (int i = 0; i < expected; i++) {
            officers.add(new Officer(Rank.ADMIRAL, "testFirst" + i, "testLast" + i));
        }
        when(jdbcTemplate.queryForList(sql, Officer.class)).thenReturn(officers);
        // Exercise

        int actual = jdbcOfficerDao.count();

        // Assert
        assertEquals(expected, actual);
    }
}