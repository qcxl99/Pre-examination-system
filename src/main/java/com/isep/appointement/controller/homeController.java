package com.isep.appointement.controller;

import com.isep.appointement.controller.doctor.DoctorService;
import com.isep.appointement.controller.patient.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class homeController {

    private final DoctorService doctorService;
    private final PatientService patientService;

    @GetMapping("/")
    public String mainPage() {
        return "首页";
    }

    @GetMapping("/home")
    public String index(Principal principal) {

        return "首页";
    }
    @GetMapping("/personal")
    public String personalPage(Principal principal) {
        String loggedInUserRole = "";
        if(doctorService.getDoctorByEmail(principal.getName()) != null){
            loggedInUserRole = "Doctor";
        }
        else if(patientService.getPatientByEmail(principal.getName()) != null){
            loggedInUserRole = "Patient";
        }
        if (loggedInUserRole.equals("Doctor")) {
            return "redirect:/info/doctor";
        }
        else {
            return "redirect:/info/patient";
        }
    }

    @GetMapping("/ourDoctor")
    public String doctor() {
        return "医生";
    }

    @GetMapping("/announcement")
    public String announcement() {
        return "公告";
    }

    @GetMapping("/science")
    public String science() {
        return "科普";
    }

    @GetMapping("/pretriage")
    public String pretriage(){
        return "Pre_Triage";
    }

    @GetMapping("/contactus")
    public String contactus(){
        return "contactus";
    }
    @GetMapping("/aboutus")
    public String aboutus(){
        return "aboutus";
    }

    @RequestMapping("/signup")
    public String test(Model model){
        model.addAttribute("msg", "hello, please Signup");
        return "signup";
    }


    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }
}
