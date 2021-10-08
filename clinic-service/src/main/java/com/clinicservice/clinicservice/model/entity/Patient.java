package com.clinicservice.clinicservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "patient_name", nullable = false)
    private String patientName;

    @Column(name = "patient_email")
    private String patientEmail;

    @Column(name = "patient_number")
    private String patientNumber;

    @Column(name = "status")
    private String status ;

    @Column(name = "created_date")
    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Appointments> appointments;

}
