package ua.diploma.service;

import ua.diploma.domain.SigninRequest;
import ua.diploma.domain.UserDTO;

public interface AuthService {

    void signup(UserDTO userDTO);

    String signin(SigninRequest request);



}
