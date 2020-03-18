package com.galvanize.startrek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
class OfficerControllerTest {

    @Mock
    MockMvc mockMvc;

    @Mock
    OfficerService officerService;


    @Test
    void getAllOfficers_returnsOfficers() throws Exception {
        //Setup
        List<Officer> officers = getTestOfficers();
        String url = "/api/officers";
        when(officerService.getAllOfficers()).thenReturn(officers);

        //Exercise & Assert

        mockMvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.", hasSize(officers.size())));
    }

    private List<Officer> getTestOfficers() {
        List<Officer> testOfficers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testOfficers.add(new Officer((Rank.ADMIRAL, "firstName" + i, "lastName" + i));
        }

        return testOfficers;
    }
}
