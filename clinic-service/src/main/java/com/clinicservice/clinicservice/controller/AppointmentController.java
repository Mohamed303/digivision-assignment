package com.clinicservice.clinicservice.controller;

import com.clinicservice.clinicservice.exceptions.ClinicExceptions;
import com.clinicservice.clinicservice.model.entity.Appointments;
import com.clinicservice.clinicservice.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/api")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments/today/{pageNum}/{pageSize}")
    public ResponseEntity<?> listAllTodayAppointments(@PathVariable  int pageNum,@PathVariable int pageSize){
       try {
           return new ResponseEntity<>(appointmentService.findTodayAppointments(pageNum,pageSize), HttpStatus.OK);
       }catch (ClinicExceptions e){
           return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
       }
    }
    @PostMapping(value = "/appointments")
    public ResponseEntity<?> saveAppointment(@RequestBody Appointments appointments){
        try {
            return new ResponseEntity<>(appointmentService.saveAppointment(appointments), HttpStatus.OK);
        }catch (ClinicExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/appointments/cancel")
    public ResponseEntity<?> saveCancelAppointment(@RequestBody Appointments appointments){
        try {
            return new ResponseEntity<>(appointmentService.cancelAppointment(appointments), HttpStatus.OK);
        }catch (ClinicExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/appointments/filter/{appointmentDate}/{pageNum}/{pageSize}")
    public ResponseEntity<?> getAppointmentByDate(@PathVariable LocalDateTime appointmentDate,@PathVariable int pageNum,@PathVariable int pageSize){
        try {
            return new ResponseEntity<>(appointmentService.getAppointmentByDate(appointmentDate,pageNum,pageSize), HttpStatus.OK);
        }catch (ClinicExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/appointments/{patientId}/{pageNum}/{pageSize}")
    public ResponseEntity<?> getAppointmentByPatient(@PathVariable Long patientId,@PathVariable int pageNum,@PathVariable int pageSize){
        try {
            return new ResponseEntity<>(appointmentService.getAppointmentByPatient(patientId,pageNum,pageSize), HttpStatus.OK);
        }catch (ClinicExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/appointments/filter/name/{patientName}/{pageNum}/{pageSize}")
    public ResponseEntity<?> getAppointmentByPatientName(@PathVariable String patientName,@PathVariable int pageNum,@PathVariable int pageSize){
        try {
            return new ResponseEntity<>(appointmentService.getAppointmentByPatientName(patientName,pageNum,pageSize), HttpStatus.OK);
        }catch (ClinicExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
