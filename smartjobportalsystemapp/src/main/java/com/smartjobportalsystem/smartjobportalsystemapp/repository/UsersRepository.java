package com.smartjobportalsystem.smartjobportalsystemapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartjobportalsystem.smartjobportalsystemapp.model.Users;

public interface UsersRepository
        extends JpaRepository<Users, Integer> {

    List<Users> findByName(String name);

    List<Users> findByEmail(String email);

    List<Users> findByPhone(Long phone);

    List<Users> findByRole(String role);
}