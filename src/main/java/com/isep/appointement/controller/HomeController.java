package com.isep.appointement.controller;

import com.isep.appointement.controller.doctor.DoctorService;
import com.isep.appointement.controller.patient.PatientService;
import com.isep.appointement.model.Roles;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class HomeController {

    private final DoctorService doctorService;
    private final PatientService patientService;

    @GetMapping("/")
    public String mainPage(Principal principal) {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String index(Principal principal) {
        return "home";
    }
    @GetMapping("/personal")
    public String personalPage(Principal principal) {
        String loggedInUserRole = getLoggedInUserRole();
        if (Roles.Doctor.name().equals(loggedInUserRole)) {
            return "redirect:/info/doctor";
        }
        else {
            return "redirect:/info/patient";
        }
    }
    @GetMapping("/reservation")
    public String reservation(Principal principal) {
        String loggedInUserRole = getLoggedInUserRole();

        if (Roles.Doctor.name().equals(loggedInUserRole)) {
            return "redirect:/appointment/doctor";
        }
        else {
            return "redirect:/appointment/patient/search";
        }
    }

    @GetMapping("/ourDoctor")
    public String doctor() {
        return "ourDoctor";
    }

    @GetMapping("/announcement")
    public String announcement() {
        return "announcement";
    }

    @GetMapping("/science")
    public String science() {
        return "science";
    }

    @GetMapping("/pretriage")
    public String pretriage() {
        return "Pre_Triage";
    }

    @GetMapping("/contactus")
    public String contactus() {
        return "contactus";
    }

    @GetMapping("/aboutus")
    public String aboutus() {
        return "aboutus";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    private String getLoggedInUserRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                return authority.getAuthority();
            }
        }
        return "";
    }
}