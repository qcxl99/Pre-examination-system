package com.isep.appointement.Repository;

import com.isep.appointement.model.Doctor;
import com.isep.appointement.model.Patient;
import com.isep.appointement.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Repository
public interface AppointmentRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT d from Doctor d where d.mail = ?1")
    Optional<Doctor> findDocByMail(String email);
    @Query("SELECT d from Doctor d where d.name = ?1")
    Optional<Doctor> findDocByName(String name);

    @Query("SELECT p from Patient p where p.mail = ?1")
    Optional<Patient> findPatientsByMail(String email);
    @Query("SELECT p from Patient p where p.name = ?1")
    Optional<Patient> findPatientsByName(String name);

    @Query("SELECT r from Reservation r where r.status = ?1")
    List<Reservation> findByStatus(String status);



/*    @Modifying
    @Query("UPDATE Doctor d " +
            "SET d.enabled = TRUE, d.locked = true WHERE d.mail = ?1")
    int enablePatient(String email);*/
}
