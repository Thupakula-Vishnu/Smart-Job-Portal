package com.smartjobportalsystem.smartjobportalsystemapp.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Applications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String status;

    private Date appliedDate;

    // Many Applications -> One User
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-applications")
    private Users user;

    // Many Applications -> One Job
    @ManyToOne
    @JoinColumn(name = "job_id")
    @JsonBackReference("job-applications")
    private Jobs job;

    // Many Applications -> One Resume
    @ManyToOne
    @JoinColumn(name = "resume_id")
    @JsonBackReference("resume-applications")
    private Resumes resume;
}