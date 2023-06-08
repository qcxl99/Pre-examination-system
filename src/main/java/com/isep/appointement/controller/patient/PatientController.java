package com.isep.appointement.controller.patient;

import com.isep.appointement.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patient")
    public String getPatientsByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String keyword,
            Model model) {
        Page<Patient> patients = patientService.getPatientsByPageAndKeyword(page, size, keyword);
        model.addAttribute("patients", patients);
        return "patient";
    }

    @GetMapping("/info/patient")
    public String getPatient(Model model, Principal principal) {
        Patient patient = patientService.getPatientByEmail(principal.getName());
        model.addAttribute("patient", patient);
        return "patientShow";
    }

    @GetMapping("/patient/new")
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "addPatient";
    }

    @PostMapping("/patient")
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        patient.setPassword(new BCryptPasswordEncoder().encode(patient.getPassword()));
        patientService.addPatient(patient);
        return "redirect:/patient/new?success";
    }

    @GetMapping("/patient/edit/{id}")
    public String editPatient(@PathVariable Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "edit_Patient";
    }

    @PostMapping("/patient/{id}")
    public String updatePatient(@PathVariable Long id, @ModelAttribute("patient") Patient patient) {
        Patient existingPatient = patientService.getPatientById(id);
        existingPatient.setName(patient.getName());
        existingPatient.setPassword(new BCryptPasswordEncoder().encode(patient.getPassword()));
        existingPatient.setTelephone(patient.getTelephone());
        existingPatient.setMail(patient.getMail());
        existingPatient.setIdNumber(patient.getIdNumber());
        existingPatient.setBirthday(patient.getBirthday());
        existingPatient.setAge(patient.getAge());
        existingPatient.setSex(patient.getSex());
        existingPatient.setRole(patient.getRole());
        patientService.editPatient(existingPatient);
        return "redirect:/patient";
    }

    @PostMapping("/info/patient/{id}")
    public String saveChange(@PathVariable Long id, @ModelAttribute("patient") Patient patient) {
        Patient existingPatient = patientService.getPatientById(id);
        existingPatient.setName(patient.getName());
        existingPatient.setTelephone(patient.getTelephone());
        existingPatient.setMail(patient.getMail());
        existingPatient.setBirthday(patient.getBirthday());
        existingPatient.setAge(patient.getAge());
        existingPatient.setJob(patient.getJob());
        existingPatient.setSex(patient.getSex());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setAllergens(patient.getAllergens());
        existingPatient.setChronicDiseases(patient.getChronicDiseases());
        existingPatient.setGeneticDiseases(patient.getGeneticDiseases());
        patientService.editPatient(existingPatient);
        return "redirect:/info/patient";
    }

    @GetMapping("/info/patient/edit/{id}")
    public String modifyInfo(@PathVariable Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "patientEdit";
    }

    @GetMapping("/patient/{id}")
    public String removePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "redirect:/patient";
    }
}
