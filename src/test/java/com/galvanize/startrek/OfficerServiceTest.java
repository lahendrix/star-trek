package com.galvanize.startrek;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OfficerServiceTest {
    @MockBean
    OfficerRepository officerRepository;

    @Test
    void getAllOfficers_whenNoOfficersExist_returnsEmpty() {
        // Setup
        OfficerService officerService = new OfficerService(officerRepository);
        int expected = 0;

        // Exercise
        int actual = officerService.getAllOfficers().size();

        // Assert
        assertEquals(expected, actual);

    }

    @Test
    void getAllOfficers_whenNoOfficersExist_returnsOfficer() {
        // Setup
        OfficerService officerService = new OfficerService(officerRepository);
        List<Officer> expectedOfficerList = new ArrayList<>();
        Officer officer = new Officer(Rank.ADMIRAL, "Admiral", "Daffy");
        expectedOfficerList.add(officer);
        int expected = 1;

        when(officerRepository.findAll()).thenReturn(expectedOfficerList);

        // Exercise
        int actual = officerService.getAllOfficers().size();

        // Assert
        assertEquals(expected, actual);

    }
}
