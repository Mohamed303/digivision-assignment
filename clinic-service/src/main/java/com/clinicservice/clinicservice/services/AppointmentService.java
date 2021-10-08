package com.clinicservice.clinicservice.services;

import com.clinicservice.clinicservice.dto.ClinicResponseDto;
import com.clinicservice.clinicservice.exceptions.ClinicExceptions;
import com.clinicservice.clinicservice.model.entity.Appointments;
import com.clinicservice.clinicservice.model.repository.AppointmentsRepository;
import com.clinicservice.clinicservice.utility.ErrorMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class AppointmentService {
    private final AppointmentsRepository appointmentsRepository;

    public AppointmentService(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }

    public Appointments saveAppointment(Appointments appointments) {
        if (appointments.getPatient().getPatientId() == null)
            throw new ClinicExceptions(HttpStatus.BAD_REQUEST.value(), ErrorMessage.AppointmentShouldAssignToPatient);
        return appointmentsRepository.save(appointments);

    }

    public ClinicResponseDto findTodayAppointments(int pageNum, int pageSize) {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDate = startOfDay.toLocalDate().atTime(LocalTime.MAX);
        Page<Appointments> appointmentsPage =  appointmentsRepository.findAppointmentsByAppointmentDateBetweenTwoDates(startOfDay, endOfDate,
                PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "appointmentDate"));
        return new ClinicResponseDto(appointmentsPage.getContent(),appointmentsPage.getTotalElements());

    }

    public Appointments cancelAppointment(Appointments appointments) {
        Appointments savedAppointment = appointmentsRepository.getById(appointments.getAppointmentId());
        if(savedAppointment == null)
            throw new ClinicExceptions(HttpStatus.NOT_FOUND.value(),ErrorMessage.AppointmentNotExist);
        savedAppointment.setCancelNotice(appointments.getCancelNotice());
        return appointmentsRepository.save(savedAppointment);
    }

    public ClinicResponseDto getAppointmentByDate(LocalDateTime appointmentDate, int pageNum, int pageSize){
        Page<Appointments> appointmentsPage = appointmentsRepository.findAppointmentsByAppointmentDate(appointmentDate,
                PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "appointmentDate"));
        return new ClinicResponseDto(appointmentsPage.getContent(),appointmentsPage.getTotalElements());

    }

    public ClinicResponseDto getAppointmentByPatient(Long patientId, int pageNum, int pageSize){
        Page<Appointments> appointmentsPage =  appointmentsRepository.findAppointmentsByPatientPatientId(patientId,
                PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "appointmentDate"));
        return new ClinicResponseDto(appointmentsPage.getContent(),appointmentsPage.getTotalElements());
    }
    public ClinicResponseDto getAppointmentByPatientName(String patientName, int pageNum, int pageSize){
        Page<Appointments> appointmentsPage = appointmentsRepository.findAppointmentsByPatientPatientName(patientName,
                PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "appointmentDate"));
        return new ClinicResponseDto(appointmentsPage.getContent(),appointmentsPage.getTotalElements());

    }

}
