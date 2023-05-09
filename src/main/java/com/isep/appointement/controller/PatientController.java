package com.isep.appointement.controller;

import com.isep.appointement.model.Patient;
//import com.isep.appointement.model.PatientRepository;
//import com.isep.appointement.model.PatientService;
import com.isep.appointement.model.PatientService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/hello")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> patient(){

        return patientService.getPatient() ;
    }

    @PostMapping
    public void registerNewPatient(@RequestBody Patient patient){

        patientService.addPatient(patient);
    }
}
