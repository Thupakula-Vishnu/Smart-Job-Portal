package com.smartjobportalsystem.smartjobportalsystemapp.service;

import com.smartjobportalsystem.smartjobportalsystemapp.dto.LoginRequest;
import com.smartjobportalsystem.smartjobportalsystemapp.dto.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);
}