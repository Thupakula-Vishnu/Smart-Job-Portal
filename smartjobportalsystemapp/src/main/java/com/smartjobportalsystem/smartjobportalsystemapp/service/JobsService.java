package com.smartjobportalsystem.smartjobportalsystemapp.service;

import java.util.List;

import com.smartjobportalsystem.smartjobportalsystemapp.model.Jobs;

public interface JobsService {

    Jobs insertJobs(Jobs job);

    List<Jobs> getAllJobs();

    Jobs getJobById(Integer id);

    List<Jobs> findByLocation(String location);

    List<Jobs> findBySkillsContaining(String skills);

    List<Jobs> findByCompanyName(String companyName);

    List<Jobs> findByTitle(String title);

    Jobs updateJob(Integer id, Jobs job);

    Jobs updateJobByTitle(Integer id, String title);

    Jobs updateJobByDescription(Integer id, String description);

    Jobs updateJobByLocation(Integer id, String location);

    Jobs updateJobBySalary(Integer id, Double salary);

    Jobs updateJobBySkills(Integer id, String skills);

    Jobs updateJobByCompanyName(Integer id, String companyName);

    String deleteJob(Integer id);
}