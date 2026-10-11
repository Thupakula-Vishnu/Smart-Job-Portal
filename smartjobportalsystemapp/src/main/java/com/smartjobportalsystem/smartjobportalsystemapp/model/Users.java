package com.smartjobportalsystem.smartjobportalsystemapp.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    private String password;

    private Long phone;

    private String role;

    private Date createdDate;

    // One User -> Many Resumes
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference("user-resumes")
    private List<Resumes> resume;

    // One User -> Many Applications
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference("user-applications")
    private List<Applications> application;

    // One User -> Many Notifications
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference("user-notifications")
    private List<Notifications> notification;

    // One User -> Many Jobs
    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
    @JsonManagedReference("user-jobs")
    private List<Jobs> job;
}