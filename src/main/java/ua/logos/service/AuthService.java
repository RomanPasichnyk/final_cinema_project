package ua.logos.service;

import ua.logos.domain.SigninRequest;
import ua.logos.domain.UserDTO;

public interface AuthService {

    void signup(UserDTO userDTO);

    String signin(SigninRequest request);

}
