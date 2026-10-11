package com.smartjobportalsystem.smartjobportalsystemapp.service;

import java.util.List;

import com.smartjobportalsystem.smartjobportalsystemapp.model.Applications;

public interface ApplicationsService {

    Applications insertApplication(Applications application);

    Applications getApplicationById(Integer id);

    List<Applications> getAllApplications();

    List<Applications> getApplicationByStatus(String status);

    List<Applications> getApplicationByUserId(Integer userId);

    List<Applications> getApplicationByJobId(Integer jobId);

    List<Applications> getApplicationByResumeId(Integer resumeId);

    Applications updateApplication(Integer id, Applications application);

    Applications updateApplicationStatus(Integer id, String status);

    String deleteApplication(Integer id);
}