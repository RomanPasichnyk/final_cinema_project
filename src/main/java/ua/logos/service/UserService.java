package ua.logos.service;

import ua.logos.domain.UserDTO;

import java.util.List;

public interface UserService {

    void saveUser(UserDTO userDTO);

    List<UserDTO> getAllUser();

    UserDTO findUserById(Long id);

    UserDTO findUserByEmail(String email);

    List<UserDTO> findUserByNameLikeOrEmail(String name, String email);

    UserDTO findUserByPhoneNumber(String phoneNumber);
}
