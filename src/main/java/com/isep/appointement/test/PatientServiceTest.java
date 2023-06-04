package com.isep.appointement.test;
import com.isep.appointement.Repository.PatientRepository;
import com.isep.appointement.controller.patient.PatientService;
import com.isep.appointement.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @Test
    public void testCreatePatient_Success() {
        Patient patient = new Patient();

        Mockito.when(patientRepository.save(patient)).thenReturn(patient);

        Optional<Patient> createdPatient = patientRepository.findPatientsByMail(patient.getMail());

        Assertions.assertTrue(createdPatient.isPresent());
        Assertions.assertEquals(patient, createdPatient.get());
    }

    @Test
    public void testCreatePatient_Failure() {
        Patient patient = new Patient();

        Mockito.when(patientRepository.save(patient)).thenReturn(null);

        Optional<Patient> createdPatient = patientRepository.findPatientsByMail(patient.getMail());

        Assertions.assertFalse(createdPatient.isPresent());
    }


}
