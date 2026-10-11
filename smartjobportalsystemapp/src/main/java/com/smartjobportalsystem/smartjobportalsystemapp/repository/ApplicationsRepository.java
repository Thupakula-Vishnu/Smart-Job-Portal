package com.smartjobportalsystem.smartjobportalsystemapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartjobportalsystem.smartjobportalsystemapp.model.Applications;

public interface ApplicationsRepository
        extends JpaRepository<Applications, Integer> {

    List<Applications> findByStatus(String status);

    List<Applications> findByUserId(Integer userId);

    List<Applications> findByJobId(Integer jobId);

    List<Applications> findByResumeId(Integer resumeId);
}