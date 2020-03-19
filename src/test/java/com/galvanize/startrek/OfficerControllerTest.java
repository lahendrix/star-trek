package com.galvanize.startrek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
class OfficerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OfficerService officerService;

    @MockBean
    OfficerRepository officerRepository;

    @Test // Zero case from ZOMBIES
    void getAllOfficers_whenNoOfficersExist_returnsEmpty() throws Exception{
        // Setup
        int expected = 0;
        when(officerService.getAllOfficers()).thenReturn(new ArrayList<>());

        // Exercise & Assert
        mockMvc.perform(get("/api/officers"))
                .andDo((print()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(expected)));
    }
}
