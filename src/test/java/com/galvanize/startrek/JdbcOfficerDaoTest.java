package com.galvanize.startrek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

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
        String sql = "select count(*) from officers";
        List officers = new ArrayList<Officer>();
        Integer expected = 5;

        for (int i = 0; i < expected; i++) {
            officers.add(new Officer(Rank.ADMIRAL, "testFirst" + i, "testLast" + i));
        }
        when(jdbcTemplate.queryForObject(sql, Integer.class)).thenReturn(expected);
        // Exercise

        int actual = jdbcOfficerDao.count();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void findAllOfficers () {
        //Setup
        String sql = "select * from officers";
        List expectedOfficers = new ArrayList<Officer>();
        Integer expected = 10;
        for (int i = 0; i < expected; i++) {
            expectedOfficers.add(new Officer(Rank.ADMIRAL, "testFirst" + i, "testLast" + i));
        }
        when(jdbcTemplate.queryForList(sql, Officer.class)).thenReturn(expectedOfficers);

        // Exercise
        List actualOfficers = jdbcOfficerDao.findAllOfficers();

        // Assert
        assertIterableEquals(expectedOfficers, actualOfficers);

    }

    @Test
    void findOfficerById_whenIdDoesNotExist() {
        //Setup
        Long expectedId = 99L;
        String sql = "select * from officers where id = " + expectedId;
        Optional<Officer> expected = Optional.empty();

        //Exercise
        Optional<Officer> actual = jdbcOfficerDao.findOfficerById(expectedId);

        // Assert
        assertEquals(expected, actual);
    }
}
