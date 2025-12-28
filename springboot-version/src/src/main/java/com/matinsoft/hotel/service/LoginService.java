package com.matinsoft.hotel.service;

import com.matinsoft.hotel.dto.LoginRequest;
import com.matinsoft.hotel.dto.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest request);
}
