package com.isep.appointement.test;

import com.isep.appointement.controller.Registration.RegistrationController;
import com.isep.appointement.controller.email.EmailValidator;
import com.isep.appointement.controller.patient.PatientService;
import com.isep.appointement.model.Patient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;

    @MockBean
    private EmailValidator emailValidator;

    @Test
    public void testRegisterPatient() throws Exception {
        Patient patient = new Patient();
        patient.setMail("test@example.com");

        when(emailValidator.test(anyString())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .flashAttr("patient", patient))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/register?success"));
    }

    // Add tests for other methods in RegistrationController
}
