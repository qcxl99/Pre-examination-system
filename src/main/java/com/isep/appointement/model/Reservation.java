package com.isep.appointement.model;

import com.isep.appointement.controller.Reservation.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String appointmentTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @Column(nullable = false)
    private String doctorName;
    @Column(nullable = false)
    private String patientName;
    @Column
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus status;

    public String getAppointmentTime(){
        if(appointmentTime.contains("T")){
            LocalDateTime dateTime = LocalDateTime.parse(appointmentTime);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = dateTime.format(formatter);
            return formattedDateTime;
        }
        return appointmentTime;
    }

}
