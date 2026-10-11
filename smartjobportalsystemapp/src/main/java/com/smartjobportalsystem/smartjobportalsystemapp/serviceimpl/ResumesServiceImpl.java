package com.smartjobportalsystem.smartjobportalsystemapp.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjobportalsystem.smartjobportalsystemapp.exception.ResourceNotFoundException;
import com.smartjobportalsystem.smartjobportalsystemapp.model.Resumes;
import com.smartjobportalsystem.smartjobportalsystemapp.repository.ResumesRepository;
import com.smartjobportalsystem.smartjobportalsystemapp.service.ResumesService;

@Service
public class ResumesServiceImpl implements ResumesService {

    @Autowired
    private ResumesRepository resumesRepository;

    // INSERT RESUME
    @Override
    public Resumes insertResume(Resumes resume) {

        return resumesRepository.save(resume);
    }

    // GET ALL RESUMES
    @Override
    public List<Resumes> getAllResumes() {

        return resumesRepository.findAll();
    }

    // GET RESUME BY ID
    @Override
    public Resumes getResumeById(Integer id) {

        return resumesRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Resume not found with id : " + id
                    )
                );
    }

    // GET BY RESUME NAME
    @Override
    public List<Resumes> getResumeByName(
            String resumeName) {

        return resumesRepository.findByResumeName(resumeName);
    }

    // GET BY FILE PATH
    @Override
    public List<Resumes> getResumeByFilePath(
            String filePath) {

        return resumesRepository.findByFilePath(filePath);
    }

    // GET BY UPLOAD DATE
    @Override
    public List<Resumes> getResumeByUploadDate(
            Date uploadDate) {

        return resumesRepository.findByUploadDate(uploadDate);
    }

    // UPDATE COMPLETE RESUME
    @Override
    public Resumes updateResume(
            Integer id,
            Resumes resume) {

        Resumes existingResume = resumesRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Resume not found with id : " + id
                    )
                );

        existingResume.setResumeName(
                resume.getResumeName()
        );

        existingResume.setFilePath(
                resume.getFilePath()
        );

        existingResume.setUploadDate(
                resume.getUploadDate()
        );

        existingResume.setUser(
                resume.getUser()
        );

        return resumesRepository.save(existingResume);
    }

    // UPDATE RESUME NAME
    @Override
    public Resumes updateResumeName(
            Integer id,
            String resumeName) {

        Resumes resume = resumesRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Resume not found with id : " + id
                    )
                );

        resume.setResumeName(resumeName);

        return resumesRepository.save(resume);
    }

    // UPDATE FILE PATH
    @Override
    public Resumes updateResumeFilePath(
            Integer id,
            String filePath) {

        Resumes resume = resumesRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Resume not found with id : " + id
                    )
                );

        resume.setFilePath(filePath);

        return resumesRepository.save(resume);
    }

    // UPDATE UPLOAD DATE
    @Override
    public Resumes updateResumeUploadDate(
            Integer id,
            Date uploadDate) {

        Resumes resume = resumesRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Resume not found with id : " + id
                    )
                );

        resume.setUploadDate(uploadDate);

        return resumesRepository.save(resume);
    }

    // DELETE RESUME
    @Override
    public String deleteResume(Integer id) {

        Resumes resume = resumesRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Resume not found with id : " + id
                    )
                );

        resumesRepository.delete(resume);

        return "Resume deleted successfully";
    }
}