package com.clinicservice.clinicservice.model.repository;

import com.clinicservice.clinicservice.model.entity.Appointments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface AppointmentsRepository extends JpaRepository<Appointments,Long> {

    @Query("select ap from Appointments  ap where ap.appointmentDate between :startOfDay and :endOfDay")
    Page<Appointments>  findAppointmentsByAppointmentDateBetweenTwoDates(LocalDateTime startOfDay, LocalDateTime endOfDay, Pageable page);

    Page<Appointments> findAppointmentsByAppointmentDate(LocalDateTime appointmentDate, Pageable page);

    Page<Appointments>  findAppointmentsByPatientPatientId(Long patientId, Pageable page);

    @Query("select app from Appointments  app , Patient p where app.patient.patientId = p.patientId and p.patientName like %:patientName%")
    Page<Appointments>  findAppointmentsByPatientPatientName(String patientName, Pageable page);

}
