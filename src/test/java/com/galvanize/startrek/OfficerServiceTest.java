package com.galvanize.startrek;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OfficerServiceTest {
    @Mock
    OfficerRepository officerRepository;

    @Test
    void getAllOfficers_whenNoOfficersExist_returnsEmpty() {
        // Setup
        OfficerService officerService = new OfficerService(officerRepository);
        int expected = 0;

        // Exercise
        int actual = officerService.getAllOfficers();

        // Assert
        assertEquals(expected, actual);

    }
}
