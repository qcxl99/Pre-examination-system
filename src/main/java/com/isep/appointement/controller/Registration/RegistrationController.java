package com.isep.appointement.controller.Registration;

import com.isep.appointement.controller.email.EmailValidator;
import com.isep.appointement.controller.patient.PatientService;
import com.isep.appointement.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping(("/register"))
public class RegistrationController {

    private final PatientService patientService;
    private final EmailValidator emailValidator;

    @PostMapping
    public String registerPatient(@ModelAttribute("patient") Patient patient) {
        boolean isValidEmail = emailValidator.test(patient.getMail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email is not valid");
        }
        patientService.addPatient(patient);
        return "redirect:/register?success";
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return patientService.confirmToken(token);
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "Registration";
    }
}
