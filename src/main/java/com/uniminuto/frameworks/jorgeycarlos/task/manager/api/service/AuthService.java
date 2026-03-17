package com.uniminuto.frameworks.jorgeycarlos.task.manager.api.service;

import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.request.LoginRequestDTO;
import com.uniminuto.frameworks.jorgeycarlos.task.manager.api.model.dto.response.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO login(LoginRequestDTO request);
}