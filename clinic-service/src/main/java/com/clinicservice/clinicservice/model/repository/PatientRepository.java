package com.clinicservice.clinicservice.model.repository;

import com.clinicservice.clinicservice.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient,Long> {
}
