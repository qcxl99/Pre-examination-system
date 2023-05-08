package com.isep.appointement.model;

import com.isep.appointement.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService {
    @Autowired
    private final PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatient() {
/*        return List.of(
                new Patient(1L,
                "p1",
                "1111",
                "p1",
                11, 0,
                111111,
                "p1@gmail.com",
                "130102198002030211"));
    }*/

        return patientRepository.findAll();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
