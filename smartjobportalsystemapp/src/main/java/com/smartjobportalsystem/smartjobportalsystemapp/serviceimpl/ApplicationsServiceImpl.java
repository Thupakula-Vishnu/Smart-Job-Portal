package com.smartjobportalsystem.smartjobportalsystemapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjobportalsystem.smartjobportalsystemapp.exception.ResourceNotFoundException;
import com.smartjobportalsystem.smartjobportalsystemapp.model.Applications;
import com.smartjobportalsystem.smartjobportalsystemapp.repository.ApplicationsRepository;
import com.smartjobportalsystem.smartjobportalsystemapp.service.ApplicationsService;

@Service
public class ApplicationsServiceImpl implements ApplicationsService {

    @Autowired
    private ApplicationsRepository applicationsRepository;

    // INSERT APPLICATION
    @Override
    public Applications insertApplication(
            Applications application) {

        return applicationsRepository.save(application);
    }

    // GET APPLICATION BY ID
    @Override
    public Applications getApplicationById(Integer id) {

        return applicationsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Application not found with id : " + id
                    )
                );
    }

    // GET ALL APPLICATIONS
    @Override
    public List<Applications> getAllApplications() {

        return applicationsRepository.findAll();
    }

    // GET BY STATUS
    @Override
    public List<Applications> getApplicationByStatus(
            String status) {

        return applicationsRepository.findByStatus(status);
    }

    // GET BY USER ID
    @Override
    public List<Applications> getApplicationByUserId(
            Integer userId) {

        return applicationsRepository.findByUserId(userId);
    }

    // GET BY JOB ID
    @Override
    public List<Applications> getApplicationByJobId(
            Integer jobId) {

        return applicationsRepository.findByJobId(jobId);
    }

    // GET BY RESUME ID
    @Override
    public List<Applications> getApplicationByResumeId(
            Integer resumeId) {

        return applicationsRepository.findByResumeId(resumeId);
    }

    // UPDATE COMPLETE APPLICATION
    @Override
    public Applications updateApplication(
            Integer id,
            Applications application) {

        Applications existingApplication =
                applicationsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Application not found with id : " + id
                    )
                );

        existingApplication.setStatus(
                application.getStatus()
        );

        existingApplication.setAppliedDate(
                application.getAppliedDate()
        );

        existingApplication.setUser(
                application.getUser()
        );

        existingApplication.setJob(
                application.getJob()
        );

        existingApplication.setResume(
                application.getResume()
        );

        return applicationsRepository.save(
                existingApplication
        );
    }

    // UPDATE STATUS ONLY
    @Override
    public Applications updateApplicationStatus(
            Integer id,
            String status) {

        Applications application =
                applicationsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Application not found with id : " + id
                    )
                );

        application.setStatus(status);

        return applicationsRepository.save(application);
    }

    // DELETE APPLICATION
    @Override
    public String deleteApplication(Integer id) {

        Applications application =
                applicationsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Application not found with id : " + id
                    )
                );

        applicationsRepository.delete(application);

        return "Application deleted successfully";
    }
}