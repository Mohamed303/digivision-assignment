package com.clinicservice.clinicservice.dto;

import com.clinicservice.clinicservice.model.entity.Appointments;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClinicResponseDto {
    private List<Appointments> data;
    private long count;
    public ClinicResponseDto(List<Appointments> data , long count){
        this.data = data;
        this.count = count;
    }

}
