package com.smartjobportalsystem.smartjobportalsystemapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartjobportalsystem.smartjobportalsystemapp.exception.ResourceNotFoundException;
import com.smartjobportalsystem.smartjobportalsystemapp.model.Users;
import com.smartjobportalsystem.smartjobportalsystemapp.repository.UsersRepository;
import com.smartjobportalsystem.smartjobportalsystemapp.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // INSERT USER
    @Override
    public Users insertUser(Users user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        return usersRepository.save(user);
    }

    // GET ALL USERS
    @Override
    public List<Users> getAllUsers() {

        return usersRepository.findAll();
    }

    // GET USER BY ID
    @Override
    public Users getUserById(Integer id) {

        return usersRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "User not found with id : " + id
                    )
                );
    }

    // GET USER BY NAME
    @Override
    public List<Users> getUserByName(String name) {

        return usersRepository.findByName(name);
    }

    // GET USER BY EMAIL
    @Override
    public List<Users> findByEmail(String email) {

        return usersRepository.findByEmail(email);
    }

    // GET USER BY PHONE
    @Override
    public List<Users> findByPhone(Long phone) {

        return usersRepository.findByPhone(phone);
    }

    // GET USER BY ROLE
    @Override
    public List<Users> findByRole(String role) {

        return usersRepository.findByRole(role);
    }

    // UPDATE USER
    @Override
    public Users updateUser(Integer id, Users user) {

        Users existingUser = usersRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "User not found with id : " + id
                    )
                );

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        if (user.getPassword() != null &&
            !user.getPassword().isEmpty()) {

            existingUser.setPassword(
                    passwordEncoder.encode(user.getPassword())
            );
        }

        existingUser.setPhone(user.getPhone());
        existingUser.setRole(user.getRole());
        existingUser.setCreatedDate(user.getCreatedDate());

        return usersRepository.save(existingUser);
    }

    // UPDATE NAME
    @Override
    public Users updateUserByName(Integer id, String name) {

        Users user = usersRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "User not found with id : " + id
                    )
                );

        user.setName(name);

        return usersRepository.save(user);
    }

    // UPDATE EMAIL
    @Override
    public Users updateUserByEmail(Integer id, String email) {

        Users user = usersRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "User not found with id : " + id
                    )
                );

        user.setEmail(email);

        return usersRepository.save(user);
    }

    // UPDATE PASSWORD
    @Override
    public Users updateUserByPassword(
            Integer id,
            String password) {

        Users user = usersRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "User not found with id : " + id
                    )
                );

        user.setPassword(
                passwordEncoder.encode(password)
        );

        return usersRepository.save(user);
    }

    // UPDATE PHONE
    @Override
    public Users updateUserByPhone(
            Integer id,
            Long phone) {

        Users user = usersRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "User not found with id : " + id
                    )
                );

        user.setPhone(phone);

        return usersRepository.save(user);
    }

    // UPDATE ROLE
    @Override
    public Users updateUserByRole(
            Integer id,
            String role) {

        Users user = usersRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "User not found with id : " + id
                    )
                );

        user.setRole(role);

        return usersRepository.save(user);
    }

    // DELETE USER
    @Override
    public String deleteUser(Integer id) {

        Users user = usersRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "User not found with id : " + id
                    )
                );

        usersRepository.delete(user);

        return "User deleted successfully";
    }
}