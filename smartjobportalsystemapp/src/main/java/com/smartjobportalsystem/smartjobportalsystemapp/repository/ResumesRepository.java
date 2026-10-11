package com.smartjobportalsystem.smartjobportalsystemapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartjobportalsystem.smartjobportalsystemapp.model.Resumes;

public interface ResumesRepository
        extends JpaRepository<Resumes, Integer> {

    List<Resumes> findByResumeName(String resumeName);

    List<Resumes> findByFilePath(String filePath);

    List<Resumes> findByUploadDate(Date uploadDate);
}