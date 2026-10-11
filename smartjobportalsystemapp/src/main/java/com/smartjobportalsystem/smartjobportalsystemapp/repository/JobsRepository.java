package com.smartjobportalsystem.smartjobportalsystemapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartjobportalsystem.smartjobportalsystemapp.model.Jobs;

public interface JobsRepository
        extends JpaRepository<Jobs, Integer> {

    List<Jobs> findByLocation(String location);

    List<Jobs> findBySkillsContaining(String skills);

    List<Jobs> findByCompanyName(String companyName);

    List<Jobs> findByTitle(String title);
}