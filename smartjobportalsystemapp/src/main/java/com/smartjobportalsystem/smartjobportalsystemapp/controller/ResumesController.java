package com.smartjobportalsystem.smartjobportalsystemapp.controller;

import java.util.Date;
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

import com.smartjobportalsystem.smartjobportalsystemapp.model.Resumes;
import com.smartjobportalsystem.smartjobportalsystemapp.service.ResumesService;

@RestController
@RequestMapping("/resume/api")
public class ResumesController {

    @Autowired
    private ResumesService resumesService;

    @PostMapping("/insertResume")
    public Resumes insertResume(
            @RequestBody Resumes resume) {

        return resumesService.insertResume(resume);
    }

    @GetMapping("/getAllResumes")
    public List<Resumes> getAllResumes() {

        return resumesService.getAllResumes();
    }

    @GetMapping("/getResumeById/{id}")
    public Resumes getResumeById(
            @PathVariable Integer id) {

        return resumesService.getResumeById(id);
    }

    @GetMapping("/getResumeByName/{resumeName}")
    public List<Resumes> getResumeByName(
            @PathVariable String resumeName) {

        return resumesService.getResumeByName(resumeName);
    }

    @GetMapping("/getResumeByFilePath/{filePath}")
    public List<Resumes> getResumeByFilePath(
            @PathVariable String filePath) {

        return resumesService.getResumeByFilePath(filePath);
    }

    @GetMapping("/getResumeByUploadDate/{uploadDate}")
    public List<Resumes> getResumeByUploadDate(
            @PathVariable Date uploadDate) {

        return resumesService.getResumeByUploadDate(uploadDate);
    }

    @PutMapping("/updateResume/{id}")
    public Resumes updateResume(
            @PathVariable Integer id,
            @RequestBody Resumes resume) {

        return resumesService.updateResume(id, resume);
    }

    @PatchMapping("/updateResumeName/{id}/{resumeName}")
    public Resumes updateResumeName(
            @PathVariable Integer id,
            @PathVariable String resumeName) {

        return resumesService.updateResumeName(id, resumeName);
    }

    @PatchMapping("/updateResumeFilePath/{id}")
    public Resumes updateResumeFilePath(
            @PathVariable Integer id,
            @RequestBody String filePath) {

        return resumesService.updateResumeFilePath(id, filePath);
    }

    @PatchMapping("/updateResumeUploadDate/{id}")
    public Resumes updateResumeUploadDate(
            @PathVariable Integer id,
            @RequestBody Date uploadDate) {

        return resumesService.updateResumeUploadDate(id, uploadDate);
    }

    @DeleteMapping("/deleteResume/{id}")
    public String deleteResume(
            @PathVariable Integer id) {

        return resumesService.deleteResume(id);
    }
}