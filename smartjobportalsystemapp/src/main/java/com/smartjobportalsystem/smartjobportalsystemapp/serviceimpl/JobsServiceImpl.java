package com.smartjobportalsystem.smartjobportalsystemapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjobportalsystem.smartjobportalsystemapp.exception.ResourceNotFoundException;
import com.smartjobportalsystem.smartjobportalsystemapp.model.Jobs;
import com.smartjobportalsystem.smartjobportalsystemapp.repository.JobsRepository;
import com.smartjobportalsystem.smartjobportalsystemapp.service.JobsService;

@Service
public class JobsServiceImpl implements JobsService {

    @Autowired
    private JobsRepository jobsRepository;

    // INSERT JOB
    @Override
    public Jobs insertJobs(Jobs job) {

        return jobsRepository.save(job);
    }

    // GET ALL JOBS
    @Override
    public List<Jobs> getAllJobs() {

        return jobsRepository.findAll();
    }

    // GET JOB BY ID
    @Override
    public Jobs getJobById(Integer id) {

        return jobsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Job not found with id : " + id
                    )
                );
    }

    // FIND BY LOCATION
    @Override
    public List<Jobs> findByLocation(String location) {

        return jobsRepository.findByLocation(location);
    }

    // FIND BY SKILLS
    @Override
    public List<Jobs> findBySkillsContaining(String skills) {

        return jobsRepository.findBySkillsContaining(skills);
    }

    // FIND BY COMPANY NAME
    @Override
    public List<Jobs> findByCompanyName(String companyName) {

        return jobsRepository.findByCompanyName(companyName);
    }

    // FIND BY TITLE
    @Override
    public List<Jobs> findByTitle(String title) {

        return jobsRepository.findByTitle(title);
    }

    // UPDATE COMPLETE JOB
    @Override
    public Jobs updateJob(Integer id, Jobs job) {

        Jobs existingJob = jobsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Job not found with id : " + id
                    )
                );

        existingJob.setTitle(job.getTitle());
        existingJob.setDescription(job.getDescription());
        existingJob.setLocation(job.getLocation());
        existingJob.setSalary(job.getSalary());
        existingJob.setSkills(job.getSkills());
        existingJob.setCompanyName(job.getCompanyName());
        existingJob.setPostedDate(job.getPostedDate());
        existingJob.setRecruiter(job.getRecruiter());

        return jobsRepository.save(existingJob);
    }

    // UPDATE TITLE
    @Override
    public Jobs updateJobByTitle(
            Integer id,
            String title) {

        Jobs job = jobsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Job not found with id : " + id
                    )
                );

        job.setTitle(title);

        return jobsRepository.save(job);
    }

    // UPDATE DESCRIPTION
    @Override
    public Jobs updateJobByDescription(
            Integer id,
            String description) {

        Jobs job = jobsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Job not found with id : " + id
                    )
                );

        job.setDescription(description);

        return jobsRepository.save(job);
    }

    // UPDATE LOCATION
    @Override
    public Jobs updateJobByLocation(
            Integer id,
            String location) {

        Jobs job = jobsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Job not found with id : " + id
                    )
                );

        job.setLocation(location);

        return jobsRepository.save(job);
    }

    // UPDATE SALARY
    @Override
    public Jobs updateJobBySalary(
            Integer id,
            Double salary) {

        Jobs job = jobsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Job not found with id : " + id
                    )
                );

        job.setSalary(salary);

        return jobsRepository.save(job);
    }

    // UPDATE SKILLS
    @Override
    public Jobs updateJobBySkills(
            Integer id,
            String skills) {

        Jobs job = jobsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Job not found with id : " + id
                    )
                );

        job.setSkills(skills);

        return jobsRepository.save(job);
    }

    // UPDATE COMPANY NAME
    @Override
    public Jobs updateJobByCompanyName(
            Integer id,
            String companyName) {

        Jobs job = jobsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Job not found with id : " + id
                    )
                );

        job.setCompanyName(companyName);

        return jobsRepository.save(job);
    }

    // DELETE JOB
    @Override
    public String deleteJob(Integer id) {

        Jobs job = jobsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Job not found with id : " + id
                    )
                );

        jobsRepository.delete(job);

        return "Job deleted successfully";
    }
}