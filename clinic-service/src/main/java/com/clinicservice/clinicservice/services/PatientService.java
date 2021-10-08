package com.clinicservice.clinicservice.services;

import com.clinicservice.clinicservice.model.entity.Patient;
import com.clinicservice.clinicservice.model.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
   public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }
}
