package ua.diploma.service;

import ua.diploma.domain.UserDTO;

import java.util.List;

public interface UserService {

    void saveUser(UserDTO userDTO);

    List<UserDTO> getAllUser();

    UserDTO findUserById(Long id);

    List<UserDTO> findUserByNameLikeOrEmail(String name, String email);

    UserDTO findUserByPhoneNumber(String phoneNumber);

    UserDTO findUserByEmail(String email);

    void updateUser(UserDTO userDTO, String email);

    void addImageToUser(String image, Long id);

}
