package com.smartjobportalsystem.smartjobportalsystemapp.serviceimpl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.smartjobportalsystem.smartjobportalsystemapp.dto.LoginRequest;
import com.smartjobportalsystem.smartjobportalsystemapp.dto.LoginResponse;
import com.smartjobportalsystem.smartjobportalsystemapp.model.Users;
import com.smartjobportalsystem.smartjobportalsystemapp.repository.UsersRepository;
import com.smartjobportalsystem.smartjobportalsystemapp.security.JwtService;
import com.smartjobportalsystem.smartjobportalsystemapp.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsersRepository usersRepository;
    private final JwtService jwtService;

    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UsersRepository usersRepository,
            JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.usersRepository = usersRepository;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                    )
                );

        UserDetails userDetails =
                (UserDetails) authentication.getPrincipal();

        Users user = usersRepository.findByEmail(request.getEmail())
                .stream()
                .findFirst()
                .orElseThrow(() ->
                    new RuntimeException("User not found")
                );

        String token = jwtService.generateToken(userDetails);

        return new LoginResponse(
                "Login successful",
                user.getEmail(),
                user.getRole(),
                token
        );
    }
}