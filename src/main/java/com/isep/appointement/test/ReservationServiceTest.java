package com.isep.appointement.test;

import com.isep.appointement.Repository.AppointmentRepository;
import com.isep.appointement.Repository.PatientRepository;
import com.isep.appointement.controller.AppointmentService;
import com.isep.appointement.controller.patient.PatientService;
import com.isep.appointement.model.AppointmentStatus;
import com.isep.appointement.model.Patient;
import com.isep.appointement.model.Reservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ReservationServiceTest {

    @Mock
    private AppointmentRepository reservationRepository;
    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private AppointmentService reservationService;
    @InjectMocks
    private PatientService patientService;

    @Test
    public void testGetReservationById_Success() {
        Long reservationId = 5L;
        Reservation reservation = new Reservation();
        reservation.setId(reservationId);
        reservation.setAppointmentTime(LocalDateTime.now().toString());
        reservation.setStatus(AppointmentStatus.enabled);

        Mockito.when(reservationRepository.findById(reservationId)).thenReturn(Optional.of(reservation));

        Reservation retrievedReservation = reservationService.findAppointmentById(reservationId);

        Assertions.assertTrue(retrievedReservation != null);
        Assertions.assertEquals(reservation, retrievedReservation);
    }

    @Test
    public void testGetReservationById_Failure_NotFound() {
        Long reservationId = 5L;

        Mockito.when(reservationRepository.findById(reservationId)).thenReturn(Optional.empty());


        Reservation retrievedReservation = reservationService.findAppointmentById(reservationId);

        Assertions.assertTrue(retrievedReservation != null);
    }

    @Test
    public void testGetReservationsByPatient_Success() {
        Long patientId = 8L;
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(new Reservation());
        reservations.add(new Reservation());
        reservations.add(new Reservation());
        Patient patient = patientRepository.findById(patientId).get();
        Mockito.when(reservationRepository.findByPatient(patient, PageRequest.of(0, 100)).getContent()).thenReturn(reservations);

        List<Reservation> retrievedReservations = reservationService.getAppointmentsPatient(0,100,null, patient).getContent();

        Assertions.assertEquals(reservations.size(), retrievedReservations.size());
        Assertions.assertEquals(reservations, retrievedReservations);
    }


}
