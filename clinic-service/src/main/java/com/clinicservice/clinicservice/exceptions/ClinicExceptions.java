package com.clinicservice.clinicservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClinicExceptions extends RuntimeException {
    private int errorCode;
    private String errorMessage;

  }
