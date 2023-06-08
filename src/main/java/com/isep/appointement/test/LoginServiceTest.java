package com.isep.appointement.test;

import com.isep.appointement.Repository.DoctorRepository;
import com.isep.appointement.Repository.PatientRepository;
import com.isep.appointement.controller.doctor.DoctorService;
import com.isep.appointement.controller.patient.PatientService;
import com.isep.appointement.model.Doctor;
import com.isep.appointement.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootTest
public class LoginServiceTest {

    @Mock
    private PatientRepository patientRepository;
    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private PatientService patientService;
    @InjectMocks
    private DoctorService doctorService;

    @Test
    public void testLoadUserByUsername_ExistingPatient() {
        Patient patient = new Patient("username@1", "password");

        Mockito.when(patientRepository.findPatientsByMail("username@1").get()).thenReturn(patient);

        UserDetails userDetails = patientService.loadUserByUsername("username@1");

        Assertions.assertNotNull(userDetails);
        Assertions.assertEquals(patient.getUsername(), userDetails.getUsername());
        Assertions.assertEquals(patient.getPassword(), userDetails.getPassword());
        // Add assertions for other patient details
    }

    @Test
    public void testLoadUserByUsername_NonExistingPatient() {
        Mockito.when(patientRepository.findPatientsByMail("username@1").get()).thenReturn(null);

        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            patientService.loadUserByUsername("username@1");
        });
    }

    @Test
    public void testLoadUserByUsername_ExistingDoctor() {
        Doctor doctor = new Doctor("username@1", "password");

        Mockito.when(doctorRepository.findByMail("username@1").get()).thenReturn(doctor);

        UserDetails userDetails = doctorService.loadUserByUsername("username@1");

        Assertions.assertNotNull(userDetails);
        Assertions.assertEquals(doctor.getUsername(), userDetails.getUsername());
        Assertions.assertEquals(doctor.getPassword(), userDetails.getPassword());
    }

    @Test
    public void testLoadUserByUsername_NonExistingDoctor() {
        Mockito.when(doctorRepository.findByMail("username@1").get()).thenReturn(null);

        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            doctorService.loadUserByUsername("username@1");
        });
    }

}
