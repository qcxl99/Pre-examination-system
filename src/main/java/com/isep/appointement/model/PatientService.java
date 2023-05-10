package com.isep.appointement.model;

import com.isep.appointement.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private final PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatient() {

        return patientRepository.findAll();
    }
    public Patient getPatientById(Long id) {

        return patientRepository.findById(id).get();
    }
    public void addPatient(Patient patient) {
        Optional<Patient> patientsByMail =  patientRepository.findPatientsByMail(patient.getMail());
        if(patientsByMail.isPresent()){
            throw new IllegalStateException("email existed ");
        }
        patientRepository.save(patient);
    }

    public void editPatient(Patient patient) {
        Optional<Patient> patientsById =  patientRepository.findPatientsById(patient.getId());
        if(patientsById.isPresent()){
            throw new IllegalStateException("patient id does not exist ");
        }
        patientRepository.save(patient);
    }
    public void deletePatient(Long id) {
/*        Optional<Patient> patientsById =  patientRepository.findPatientsById(patient.getId());
        if(patientsById.isPresent()){
            throw new IllegalStateException("patient id does not exist ");
        }*/
        patientRepository.deleteById(id);
    }
}
