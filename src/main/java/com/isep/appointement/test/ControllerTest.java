package com.isep.appointement.test;

import com.isep.appointement.controller.homeController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(homeController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePageUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home")); // Replace "home" with the expected view name
    }

    @Test
    public void testRegistrationUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/registration"))
                .andExpect(status().isOk())
                .andExpect(view().name("registration")); // Replace "registration" with the expected view name
    }

    @Test
    public void testLoginUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login")); // Replace "login" with the expected view name
    }
}
