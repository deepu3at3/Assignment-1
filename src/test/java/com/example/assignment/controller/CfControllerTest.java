package com.example.assignment.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class CfControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testCfData() throws Exception{
        mockMvc.perform(get("/cf/"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void testCfProvider() throws Exception{
        mockMvc.perform(get("/cf/BLU"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testCfBadProvider() throws Exception{
        mockMvc.perform(get("/cf/LWD"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testCfInternalError() throws Exception{
         mockMvc.perform(get("/error").accept(MediaType.APPLICATION_JSON))
                     .andExpect(jsonPath("$.description",Matchers.is("Something goes wrong")));

    }


}