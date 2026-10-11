package com.smartjobportalsystem.smartjobportalsystemapp.service;

import java.util.List;

import com.smartjobportalsystem.smartjobportalsystemapp.model.Users;

public interface UsersService {

    Users insertUser(Users user);

    List<Users> getAllUsers();

    Users getUserById(Integer id);

    List<Users> getUserByName(String name);

    List<Users> findByEmail(String email);

    List<Users> findByPhone(Long phone);

    List<Users> findByRole(String role);

    Users updateUser(Integer id, Users user);

    Users updateUserByName(Integer id, String name);

    Users updateUserByEmail(Integer id, String email);

    Users updateUserByPassword(Integer id, String password);

    Users updateUserByPhone(Integer id, Long phone);

    Users updateUserByRole(Integer id, String role);

    String deleteUser(Integer id);
}