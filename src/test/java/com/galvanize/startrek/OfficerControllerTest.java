package com.galvanize.startrek;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.isNotNull;
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


    @Test // Zero case from ZOMBIES
    void getAllOfficers_whenNoOfficersExist_returnsEmpty() throws Exception{
        // Setup
        int expected = 0;
        when(officerService.getAllOfficers()).thenReturn(new ArrayList<>());

        // Exercise & Assert
        mockMvc.perform(get("/api/officers").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(expected)));
    }

    @Test // One Case from ZOMBIES
    void getAllOfficers_whenNoOfficersExist_returnsOfficers() throws Exception {
        //Setup
        List<Officer> expectedOfficers = getTestListOfOfficers(1);
        when(officerService.getAllOfficers()).thenReturn(expectedOfficers);

        // Exercise & Assert
        mockMvc.perform(get("/api/officers").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(expectedOfficers.size())))
                .andExpect(jsonPath("$[0].rank").value(is(expectedOfficers.get(0).getRank().name())))
                .andExpect(jsonPath("$[0].first").value(is(expectedOfficers.get(0).getFirst())))
                .andExpect(jsonPath("$[0].last").value(is(expectedOfficers.get(0).getLast())));;
    }

    @Test
    void createOfficer_returnsOfficer() throws Exception {
        // Setup
        Officer newOfficer = new Officer(Rank.COMMANDER, "New", "Officer");
        ObjectMapper objectMapper = new ObjectMapper();
        String newOfficerAsJson = objectMapper.writeValueAsString(newOfficer);
        newOfficer.setId(1L);
        when(officerService.createOfficer(newOfficer)).thenReturn(newOfficer);

        // Exercise & Assert
        mockMvc.perform(post("/api/officers").content(newOfficerAsJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(notNullValue()))
                .andExpect(jsonPath("$.rank").value(newOfficer.getRank().name()))
                .andExpect(jsonPath("$.first").value(newOfficer.getFirst()))
                .andExpect(jsonPath("$.last").value(newOfficer.getLast()));

    }

    private List<Officer> getTestListOfOfficers(int numOfOfficers) {
        List<Officer> officers = new ArrayList<>();
        for (int i = 0; i < numOfOfficers; i++) {
            officers.add(new Officer(Rank.ADMIRAL, "firstName" + i, "lastName" + i));
        }

        return officers;
    }
}
