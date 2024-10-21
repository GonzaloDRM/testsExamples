package com.parameterized.test.controller;

import com.parameterized.test.service.ObjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ObjectControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ObjectService objectService;

    @BeforeEach
    void setUp(){
        var controller = new ObjectController(objectService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Test controller")
    void testController() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getObject", 1L)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test controller for post")
    void testPostController() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/postObject", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .header("headerName", "headerValue")
                .param("nameParam", "paramValue");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(201))
                .andExpect(jsonPath("$.description").value("text"));
    }

}
