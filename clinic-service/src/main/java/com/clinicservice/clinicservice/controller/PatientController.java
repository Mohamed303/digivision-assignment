package com.clinicservice.clinicservice.controller;

import com.clinicservice.clinicservice.exceptions.ClinicExceptions;
import com.clinicservice.clinicservice.model.entity.Patient;
import com.clinicservice.clinicservice.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping ("/addPatient")
    public ResponseEntity<?> savePatient(@RequestBody Patient patient){
        try {
            return new ResponseEntity(patientService.savePatient(patient), HttpStatus.OK);
        }catch (ClinicExceptions e){
            return new ResponseEntity(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
