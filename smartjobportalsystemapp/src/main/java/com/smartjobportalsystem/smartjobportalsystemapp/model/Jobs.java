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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private String location;

    private Double salary;

    private String skills;

    private String companyName;

    private Date postedDate;

    // Many Jobs -> One Recruiter(User)
    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    @JsonBackReference("user-jobs")
    private Users recruiter;

    // One Job -> Many Applications
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    @JsonManagedReference("job-applications")
    private List<Applications> applications;
}