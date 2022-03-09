package com.udacity.dogProject.web;

import com.udacity.dogProject.config.EncoderConfig;
import com.udacity.dogProject.config.SpringSecurityConfig;
import com.udacity.dogProject.config.TestConfig;
import com.udacity.dogProject.service.DogService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.beans.Encoder;

import static org.mockito.Mockito.times;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.verify;


@ExtendWith(SpringExtension.class)
@WebMvcTest(DogController.class)
@Import(TestConfig.class)
public class DogAPIUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DogService dogService;



    @Test
    public void getAllDogs() throws Exception{
        mockMvc.perform(get("/dogs")
                        .with(user("admin").password("password"))
                        .accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
        verify(dogService, times(1)).retrieveDogs();
    }
}
