package com.smartjobportalsystem.smartjobportalsystemapp.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resumes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resumes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String resumeName;

    private String filePath;

    private Date uploadDate;

    // Many Resumes -> One User
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-resumes")
    private Users user;

    // One Resume -> Many Applications
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    @JsonManagedReference("resume-applications")
    private List<Applications> applications;
}