package com.isep.appointement.controller.Reservation;

import com.isep.appointement.Repository.DoctorRepository;
import com.isep.appointement.controller.doctor.DoctorService;
import com.isep.appointement.controller.patient.PatientService;
import com.isep.appointement.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final DoctorService doctorService;

    // Admin
    @GetMapping
    public String showAllAppointmentsByKeyword(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String keywordApp,
            Model model) {
        model.addAttribute("reservations", appointmentService.getAppointmentsByPageAndKeyword(page, size, keywordApp));
        return "Appointment";
    }

    @GetMapping("/pending")
    public String showPendingAppointments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        model.addAttribute("reservations", appointmentService.findByStatus(AppointmentStatus.pending.name(), page, size));
        return "Appointment";
    }

    @GetMapping("/new")
    public String addAppointment(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "add_appointment";
    }

    @PostMapping
    public String saveAppointment(@ModelAttribute("reservation") Reservation reservation) {
        appointmentService.addAppointment(reservation);
        return "redirect:/appointment/new?success";
    }

    @GetMapping("/edit/{id}")
    public String editAppointment(@PathVariable Long id, Model model) {
        model.addAttribute("reservation", appointmentService.findAppointmentById(id));
        return "edit_appointment";
    }

    @PostMapping("/{id}")
    public String updateAppointment(@PathVariable Long id,
                                    @RequestParam(required = false) Long idPat,
                                    @RequestParam(required = false) Long idDoc,
                                    @ModelAttribute("reservation") Reservation reservation, Model model) {
        Reservation existingReservation = appointmentService.findAppointmentById(id);
        existingReservation.setDoctor(doctorService.getDoctorById(idDoc));
        existingReservation.setPatient(patientService.getPatientById(idPat));
        existingReservation.setPatientName(existingReservation.getPatient().getName());
        existingReservation.setDoctorName(existingReservation.getDoctor().getName());
        existingReservation.setAppointmentTime(reservation.getAppointmentTime());
        existingReservation.setLocation(reservation.getDoctor().getHospital().getAddress());
        existingReservation.setStatus(reservation.getStatus());
        appointmentService.addAppointment(existingReservation);
        return "redirect:/appointment";
    }

    @GetMapping("/{id}")
    public String removeAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointment";
    }

    // Patient
    @GetMapping("/patient")
    public String showPatientAppointmentsByKeyword(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String keywordPat,
            Model model, Principal principal) {
        String email = principal.getName();
        Patient patient = patientService.getPatientByEmail(email);
        model.addAttribute("reservations", appointmentService.getAppointmentsPatient(page, size, keywordPat, patient));
        return "appointment_patient";
    }

    @GetMapping("patient/search")
    public String searchDoctor(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String keywordDoc,
            Model model) {
        model.addAttribute("doctors", doctorService.getDoctorsByPageAndKeyword(page, size, keywordDoc));
        return "AppointmentSearch";
    }

    @GetMapping("patient/confirm/{idDoc}")
    public String confirmAppointment(@PathVariable Long idDoc, Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("doctor", doctorService.getDoctorById(idDoc));
        return "AppointmentConfirm";
    }

    @PostMapping("patient/new/{idDoc}")
    public String saveAppointmentPatient(@PathVariable Long idDoc,
                                         @ModelAttribute("reservation") Reservation reservation,
                                         Principal principal) {
        Doctor doctor = doctorService.getDoctorById(idDoc);
        Patient patient = patientService.getPatientByEmail(principal.getName());
        reservation.setPatient(patient);
        reservation.setDoctor(doctor);
        reservation.setDoctorName(doctor.getName());
        reservation.setPatientName(patient.getName());
        reservation.setLocation(doctor.getHospital().getAddress());
        reservation.setStatus(AppointmentStatus.pending);
        appointmentService.addAppointment(reservation);
        return "redirect:/appointment/patient";
    }

    @PostMapping("patient/{id}")
    public String updateAppointmentPatient(@PathVariable Long id,
                                           @ModelAttribute("reservation") Reservation reservation,
                                           Model model) {
        Reservation existingReservation = appointmentService.findAppointmentById(id);
        existingReservation.setDoctorName(reservation.getDoctorName());
        existingReservation.setPatientName(reservation.getPatientName());
        existingReservation.setLocation(reservation.getLocation());
        existingReservation.setAppointmentTime(reservation.getAppointmentTime());
        appointmentService.editAppointment(existingReservation);
        return "redirect:/appointment/patient";
    }

    @GetMapping("patient/edit/{id}")
    public String editAppointmentPatient(@PathVariable Long id, Model model) {
        model.addAttribute("reservation", appointmentService.findAppointmentById(id));
        return "edit_appointment_patient";
    }

    @GetMapping("/patient/{id}")
    public String cancelAppointmentPatient(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
        return "redirect:/appointment/patient";
    }

    // Doctor
    @GetMapping("/doctor")
    public String showDoctorAppointments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String keywordDoc,
            Model model, Principal principal) {
        String email = principal.getName();
        Doctor doctor = doctorService.getDoctorByEmail(email);
        model.addAttribute("reservations", appointmentService.getAppointmentsDoctor(page, size, keywordDoc, doctor));
        return "appointment_doctor";
    }

    @GetMapping("/doctor/accept/{id}")
    public String acceptAppointment(@PathVariable Long id) {
        appointmentService.acceptAppointment(id);
        return "redirect:/appointment/doctor";
    }

    @GetMapping("/doctor/{id}")
    public String cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
        return "redirect:/appointment/doctor";
    }
}

