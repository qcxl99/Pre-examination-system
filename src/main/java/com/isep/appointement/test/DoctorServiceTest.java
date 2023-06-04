package com.isep.appointement.test;

import com.isep.appointement.Repository.DoctorRepository;
import com.isep.appointement.controller.doctor.DoctorService;
import com.isep.appointement.model.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @Test
    public void testCreateDoctor_Success() {
        Doctor doctor = new Doctor();

        Mockito.when(doctorRepository.save(doctor)).thenReturn(doctor);

        Optional<Doctor> createdDoctor = Optional.ofNullable(doctorService.addDoctor(doctor));

        Assertions.assertTrue(createdDoctor.isPresent());
        Assertions.assertEquals(doctor, createdDoctor.get());
    }

    @Test
    public void testCreateDoctor_Failure() {
        Doctor doctor = new Doctor();

        Mockito.when(doctorRepository.save(doctor)).thenReturn(null);

        Optional<Doctor> createdDoctor = Optional.ofNullable(doctorService.addDoctor(doctor));

        Assertions.assertFalse(createdDoctor.isPresent());
    }


}
