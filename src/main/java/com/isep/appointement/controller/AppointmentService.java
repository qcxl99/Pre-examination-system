package com.isep.appointement.controller;

import com.isep.appointement.Repository.AppointmentRepository;
import com.isep.appointement.Repository.PatientRepository;
import com.isep.appointement.model.AppointmentStatus;
import com.isep.appointement.model.Doctor;
import com.isep.appointement.model.Patient;
import com.isep.appointement.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public List<Reservation> getAllAppointment() {
        return appointmentRepository.findAll();
    }
    public Doctor findDoctorbyName(String name){
       return appointmentRepository.findDocByName(name).get();
    }
    public Patient findPatientbyName(String name){
        Patient patient = appointmentRepository.findPatientsByName(name).get();
        if(patient != null)
        return patient;
        else return null;
    }
    public Reservation findAppointmentById(Long id){
        return appointmentRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("appointment not found"));
    }
    public List<Reservation> findByStatus(String status){
        return appointmentRepository.findByStatus(status);
    }

    public Reservation addAppointment(Reservation reservation) {
        return appointmentRepository.save(reservation);
    }
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
    public void cancelAppointment(Long id) {
        appointmentRepository.findById(id).get().setStatus(AppointmentStatus.canceled.name());
    }
    public void acceptAppointment(Long id) {
        appointmentRepository.findById(id).get().setStatus(AppointmentStatus.enabled.name());
    }
}
