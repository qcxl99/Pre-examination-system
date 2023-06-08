package com.isep.appointement.controller.doctor;

import com.isep.appointement.model.Doctor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @GetMapping("/doctor")
    public String showDoctors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String keyword,
            Model model
    ) {
        model.addAttribute("doctors", doctorService.getDoctorsByPageAndKeyword(page, size, keyword));
        return "doctor";
    }

    @GetMapping("/info/doctor")
    public String showDoctorInfo(Model model, Principal principal) {
        model.addAttribute("doctor", doctorService.getDoctorByEmail(principal.getName()));
        return "doctorInfo";
    }

    @GetMapping("/doctor/new")
    public String addDoctor(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "addDoctor";
    }

    @GetMapping("/doctor/edit/{id}")
    public String editDoctor(@PathVariable Long id, Model model) {
        model.addAttribute("doctor", doctorService.getDoctorById(id));
        return "edit_Doctor";
    }

    @PostMapping("/doctor")
    public String saveDoctor(@Valid @ModelAttribute("doctor") Doctor doctor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addDoctor";
        }
        doctorService.addDoctor(doctor);
        return "redirect:/doctors?success";
    }

    @PostMapping("/doctor/{id}")
    public String updateAccount(
            @PathVariable Long id,
            @Valid @ModelAttribute("doctor") Doctor doctor,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            doctor.setIdDoc(id);
            model.addAttribute("doctor", doctor);
            return "edit_Doctor";
        }
        Doctor existingDoctor = doctorService.getDoctorById(id);
        updateExistingDoctor(existingDoctor, doctor);
        doctorService.editDoctor(existingDoctor);
        return "redirect:/doctors";
    }

    @PostMapping("/info/doctor/save")
    public String updateInfo(
            @Valid @ModelAttribute("doctor") Doctor doctor,
            BindingResult bindingResult,
            Model model,
            Principal principal
    ) {
        if (bindingResult.hasErrors()) {
            return "doctorInfo";
        }
        Doctor existingDoctor = doctorService.getDoctorByEmail(principal.getName());
        updateExistingDoctor(existingDoctor, doctor);
        doctorService.editDoctor(existingDoctor);
        return "redirect:/doctors/info";
    }

    @GetMapping("/doctor/{id}")
    public String removeDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors";
    }

    private void updateExistingDoctor(Doctor existingDoctor, Doctor newDoctor) {
        existingDoctor.setName(newDoctor.getName());
        existingDoctor.setPassword(new BCryptPasswordEncoder().encode(newDoctor.getPassword()));
        existingDoctor.setTelephone(newDoctor.getTelephone());
        existingDoctor.setMail(newDoctor.getMail());
        existingDoctor.setBirthday(newDoctor.getBirthday());
        existingDoctor.setAge(newDoctor.getAge());
        existingDoctor.setSex(newDoctor.getSex());
        existingDoctor.setHospitalName(newDoctor.getHospitalName());
    }
}