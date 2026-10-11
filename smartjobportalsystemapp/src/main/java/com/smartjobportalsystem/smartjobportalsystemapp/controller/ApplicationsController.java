package com.smartjobportalsystem.smartjobportalsystemapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjobportalsystem.smartjobportalsystemapp.model.Applications;
import com.smartjobportalsystem.smartjobportalsystemapp.service.ApplicationsService;

@RestController
@RequestMapping("/application/api")
public class ApplicationsController {

    @Autowired
    private ApplicationsService applicationsService;

    // INSERT
    @PostMapping("/insertApplication")
    public Applications insertApplication(
            @RequestBody Applications application) {

        return applicationsService.insertApplication(application);
    }

    // GET ALL
    @GetMapping("/getAllApplications")
    public List<Applications> getAllApplications() {

        return applicationsService.getAllApplications();
    }

    // GET BY ID
    @GetMapping("/getApplicationById/{id}")
    public Applications getApplicationById(
            @PathVariable Integer id) {

        return applicationsService.getApplicationById(id);
    }

    // GET BY STATUS
    @GetMapping("/getApplicationByStatus/{status}")
    public List<Applications> getApplicationByStatus(
            @PathVariable String status) {

        return applicationsService.getApplicationByStatus(status);
    }

    // GET BY USER ID
    @GetMapping("/getApplicationByUser/{userId}")
    public List<Applications> getApplicationByUser(
            @PathVariable Integer userId) {

        return applicationsService.getApplicationByUserId(userId);
    }

    // GET BY JOB ID
    @GetMapping("/getApplicationByJob/{jobId}")
    public List<Applications> getApplicationByJob(
            @PathVariable Integer jobId) {

        return applicationsService.getApplicationByJobId(jobId);
    }

    // GET BY RESUME ID
    @GetMapping("/getApplicationByResume/{resumeId}")
    public List<Applications> getApplicationByResume(
            @PathVariable Integer resumeId) {

        return applicationsService.getApplicationByResumeId(resumeId);
    }

    // UPDATE FULL APPLICATION
    @PutMapping("/updateApplication/{id}")
    public Applications updateApplication(
            @PathVariable Integer id,
            @RequestBody Applications application) {

        return applicationsService.updateApplication(id, application);
    }

    // UPDATE STATUS ONLY
    @PatchMapping("/updateApplicationStatus/{id}/{status}")
    public Applications updateApplicationStatus(
            @PathVariable Integer id,
            @PathVariable String status) {

        return applicationsService.updateApplicationStatus(id, status);
    }

    // DELETE
    @DeleteMapping("/deleteApplication/{id}")
    public String deleteApplication(
            @PathVariable Integer id) {

        return applicationsService.deleteApplication(id);
    }
}