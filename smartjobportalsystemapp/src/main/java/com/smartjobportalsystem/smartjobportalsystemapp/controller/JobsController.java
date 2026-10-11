package com.smartjobportalsystem.smartjobportalsystemapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjobportalsystem.smartjobportalsystemapp.model.Jobs;
import com.smartjobportalsystem.smartjobportalsystemapp.service.JobsService;

@RestController
@RequestMapping("/Jobs/api")
public class JobsController {

    @Autowired
    private JobsService jobsService;

    @PostMapping("/insertJob")
    public Jobs insertJob(
            @RequestBody Jobs job) {

        return jobsService.insertJobs(job);
    }

    @GetMapping("/getAllJobs")
    public List<Jobs> getAllJobs() {

        return jobsService.getAllJobs();
    }

    @GetMapping("/getJobById/{id}")
    public Jobs getJobById(
            @PathVariable Integer id) {

        return jobsService.getJobById(id);
    }

    @GetMapping("/getJobByLocation/{location}")
    public List<Jobs> getJobByLocation(
            @PathVariable String location) {

        return jobsService.findByLocation(location);
    }

    @GetMapping("/getJobBySkills/{skills}")
    public List<Jobs> getJobBySkills(
            @PathVariable String skills) {

        return jobsService.findBySkillsContaining(skills);
    }

    @GetMapping("/getJobByCompanyName/{companyName}")
    public List<Jobs> getJobByCompanyName(
            @PathVariable String companyName) {

        return jobsService.findByCompanyName(companyName);
    }

    @GetMapping("/getJobByTitle/{title}")
    public List<Jobs> getJobByTitle(
            @PathVariable String title) {

        return jobsService.findByTitle(title);
    }

    @PutMapping("/updateJob/{id}")
    public Jobs updateJob(
            @PathVariable Integer id,
            @RequestBody Jobs job) {

        return jobsService.updateJob(id, job);
    }

    @PatchMapping("/updateJobByTitle/{id}/{title}")
    public Jobs updateJobByTitle(
            @PathVariable Integer id,
            @PathVariable String title) {

        return jobsService.updateJobByTitle(id, title);
    }

    @PatchMapping("/updateJobByDescription/{id}")
    public Jobs updateJobByDescription(
            @PathVariable Integer id,
            @RequestBody String description) {

        return jobsService.updateJobByDescription(id, description);
    }

    @PatchMapping("/updateJobByLocation/{id}/{location}")
    public Jobs updateJobByLocation(
            @PathVariable Integer id,
            @PathVariable String location) {

        return jobsService.updateJobByLocation(id, location);
    }

    @PatchMapping("/updateJobBySalary/{id}/{salary}")
    public Jobs updateJobBySalary(
            @PathVariable Integer id,
            @PathVariable Double salary) {

        return jobsService.updateJobBySalary(id, salary);
    }

    @PatchMapping("/updateJobBySkills/{id}/{skills}")
    public Jobs updateJobBySkills(
            @PathVariable Integer id,
            @PathVariable String skills) {

        return jobsService.updateJobBySkills(id, skills);
    }

    @PatchMapping("/updateJobByCompanyName/{id}/{companyName}")
    public Jobs updateJobByCompanyName(
            @PathVariable Integer id,
            @PathVariable String companyName) {

        return jobsService.updateJobByCompanyName(id, companyName);
    }

    @DeleteMapping("/deleteJob/{id}")
    public String deleteJob(
            @PathVariable Integer id) {

        return jobsService.deleteJob(id);
    }
}