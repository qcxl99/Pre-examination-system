package com.isep.appointement.controller;

import com.isep.appointement.model.AppointmentStatus;
import com.isep.appointement.model.Patient;
import com.isep.appointement.model.Reservation;
import com.isep.appointement.model.TimeLine;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/appointment")
    public String showPatient(Model model){

        model.addAttribute("reservations", appointmentService.getAllAppointment());
        return "Appointment";
    }
    @GetMapping("/appointment/pending")
    public String showPending(Model model){

        model.addAttribute("reservations", appointmentService.findByStatus(AppointmentStatus.pending.name()));
        return "Appointment";
    }
    @GetMapping("/appointment/new")
    public String addPatient(Model model){
        model.addAttribute("reservation", new Reservation());

        return "add_appointment";
    }
    @PostMapping("/appointment")
    public String savePatient(@ModelAttribute("reservation") Reservation reservation){
        appointmentService.addAppointment(reservation);

        return "redirect:/appointment/new?success";
    }
    @GetMapping("/appointment/edit/{id}")
    public String editAppointment(@PathVariable Long id, Model model){
        model.addAttribute("reservation", appointmentService.findAppointmentById(id));

        return "edit_appointment";
    }
    @PostMapping("/appointment/{id}")
    public String UpdateAppointment(@PathVariable Long id, @ModelAttribute("reservation") Reservation reservation, Model model){
        Reservation existingReservation = appointmentService.findAppointmentById(id);
       existingReservation.setDoctorName(reservation.getDoctorName());
       existingReservation.setPatientName(reservation.getPatientName());
       existingReservation.setAppointmentTime(reservation.getAppointmentTime());
       existingReservation.setLocation(reservation.getLocation());
/*       existingReservation.setPatient(appointmentService.findPatientbyName(reservation.getPatientName()));
       existingReservation.setDoctor(appointmentService.);*/
       existingReservation.setStatus(reservation.getStatus());


        appointmentService.addAppointment(existingReservation);
        return "redirect:/appointment";
    }

    @GetMapping("/appointment/{id}")
    public String RemoveAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return "redirect:/appointment";
    }
}
