package com.smartjobportalsystem.smartjobportalsystemapp.service;

import java.util.Date;
import java.util.List;

import com.smartjobportalsystem.smartjobportalsystemapp.model.Resumes;

public interface ResumesService {

    Resumes insertResume(Resumes resume);

    List<Resumes> getAllResumes();

    Resumes getResumeById(Integer id);

    List<Resumes> getResumeByName(String resumeName);

    List<Resumes> getResumeByFilePath(String filePath);

    List<Resumes> getResumeByUploadDate(Date uploadDate);

    Resumes updateResume(Integer id, Resumes resume);

    Resumes updateResumeName(Integer id, String resumeName);

    Resumes updateResumeFilePath(Integer id, String filePath);

    Resumes updateResumeUploadDate(Integer id, Date uploadDate);

    String deleteResume(Integer id);
}