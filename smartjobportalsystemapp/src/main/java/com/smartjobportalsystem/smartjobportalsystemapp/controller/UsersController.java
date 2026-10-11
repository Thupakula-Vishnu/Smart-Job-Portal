package com.smartjobportalsystem.smartjobportalsystemapp.controller;

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

import com.smartjobportalsystem.smartjobportalsystemapp.model.Users;
import com.smartjobportalsystem.smartjobportalsystemapp.service.UsersService;

@RestController
@RequestMapping("/user/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/insertUser")
    public Users insertUser(
            @RequestBody Users user) {

        return usersService.insertUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<Users> getAllUsers() {

        return usersService.getAllUsers();
    }

    @GetMapping("/getUserById/{id}")
    public Users getUserById(
            @PathVariable Integer id) {

        return usersService.getUserById(id);
    }

    @GetMapping("/getUserByName/{name}")
    public List<Users> getUserByName(
            @PathVariable String name) {

        return usersService.getUserByName(name);
    }

    @GetMapping("/getUserByEmail/{email}")
    public List<Users> findByEmail(
            @PathVariable String email) {

        return usersService.findByEmail(email);
    }

    @GetMapping("/getUserByPhone/{phone}")
    public List<Users> findByPhone(
            @PathVariable Long phone) {

        return usersService.findByPhone(phone);
    }

    @GetMapping("/getUserByRole/{role}")
    public List<Users> findByRole(
            @PathVariable String role) {

        return usersService.findByRole(role);
    }

    @PutMapping("/updateUser/{id}")
    public Users updateUser(
            @PathVariable Integer id,
            @RequestBody Users user) {

        return usersService.updateUser(id, user);
    }

    @PatchMapping("/updateUserByName/{id}/{name}")
    public Users updateUserByName(
            @PathVariable Integer id,
            @PathVariable String name) {

        return usersService.updateUserByName(id, name);
    }

    @PatchMapping("/updateUserByEmail/{id}/{email}")
    public Users updateUserByEmail(
            @PathVariable Integer id,
            @PathVariable String email) {

        return usersService.updateUserByEmail(id, email);
    }

    @PatchMapping("/updateUserByPassword/{id}")
    public Users updateUserByPassword(
            @PathVariable Integer id,
            @RequestBody String password) {

        return usersService.updateUserByPassword(id, password);
    }

    @PatchMapping("/updateUserByPhone/{id}/{phone}")
    public Users updateUserByPhone(
            @PathVariable Integer id,
            @PathVariable Long phone) {

        return usersService.updateUserByPhone(id, phone);
    }

    @PatchMapping("/updateUserByRole/{id}/{role}")
    public Users updateUserByRole(
            @PathVariable Integer id,
            @PathVariable String role) {

        return usersService.updateUserByRole(id, role);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(
            @PathVariable Integer id) {

        return usersService.deleteUser(id);
    }
}