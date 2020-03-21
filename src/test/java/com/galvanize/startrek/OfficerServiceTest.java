package com.galvanize.startrek;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class OfficerServiceTest {
    @Autowired
    OfficerRepository officerRepository;

    OfficerService officerService;

    @BeforeEach
    void setup () {
        officerService = new OfficerService(officerRepository);
    }

    @Test
    void getAllOfficers_whenNoOfficersExist_returnsEmpty() {
        // Setup
        OfficerService officerService = new OfficerService(officerRepository);

        int expected = 0;

        // Exercise
        int actual = officerService.getAllOfficers().size();

        // Assert
        assertEquals(expected, actual);

        // Teardown


    }

    @Test
    void getAllOfficers_whenNoOfficersExist_returnsOfficer() {
        // Setup
        OfficerService officerService = new OfficerService(officerRepository);
        Officer officer = new Officer(Rank.ADMIRAL, "Admiral", "Daffy");
        officerRepository.save(officer);
        int expected = 1;


        // Exercise
        int actual = officerService.getAllOfficers().size();

        // Assert
        assertEquals(expected, actual);

        // Teardown
        officerRepository.deleteAll();

    }
}
