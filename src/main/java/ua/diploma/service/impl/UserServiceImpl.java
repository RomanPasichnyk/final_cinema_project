package ua.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.diploma.domain.UserDTO;
import ua.diploma.entity.UserEntity;
import ua.diploma.exception.AlreadyExistsException;
import ua.diploma.exception.ResourceNotFoundException;
import ua.diploma.repository.UserRepository;
import ua.diploma.service.UserService;
import ua.diploma.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userRepository.save(userEntity);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOS = modelMapper.mapAll(userEntities, UserDTO.class);
        return userDTOS;
    }

    @Override
    public UserDTO findUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id[" + id + "] not found"));
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
        return userDTO;
    }


    @Override
    public List<UserDTO> findUserByNameLikeOrEmail(String name, String email) {
        List<UserEntity> userEntities = userRepository.findByNameLikeOrEmail(name, email);
        List<UserDTO> userDTOS = modelMapper.mapAll(userEntities, UserDTO.class);
        return userDTOS;
    }

    @Override
    public UserDTO findUserByPhoneNumber(String phoneNumber) {
        UserEntity userEntity = userRepository.findByPhoneNumber(phoneNumber);
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
        return userDTO;
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email).get();
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
        return userDTO;
    }


    @Override
    public void updateUser(UserDTO userDTO, String email) {

        UserEntity userEntity = userRepository.findByEmail(email).get();
        UserEntity newUserEntity = modelMapper.map(userDTO, UserEntity.class);

        if (passwordEncoder.matches(userDTO.getConfirmPassword(),userEntity.getPassword())) {
            userEntity.setPassword(passwordEncoder.encode(newUserEntity.getPassword()));
        } else {
            throw new ResourceNotFoundException("The incorrect password for confirm!");
        }

        if (!newUserEntity.getEmail().equals(userEntity.getEmail())) {
            if (userRepository.existsByEmail(newUserEntity.getEmail())) {
                throw new AlreadyExistsException("User with email " + userDTO.getEmail() + " already exists");
            }
        }

        if (!newUserEntity.getPhoneNumber().equals(userEntity.getPhoneNumber())) {
            if (userRepository.existsByPhoneNumber(newUserEntity.getPhoneNumber())) {
                throw new AlreadyExistsException("User with phoneNumber " + userDTO.getPhoneNumber() + " already exists");
            }
        }

        userEntity.setAge(newUserEntity.getAge());
        userEntity.setBirthDate(newUserEntity.getBirthDate());
        userEntity.setName(newUserEntity.getName());
        userEntity.setPhoneNumber(newUserEntity.getPhoneNumber());
        userEntity.setGender(newUserEntity.getGender());
        userEntity.setFavoriteGenre(newUserEntity.getFavoriteGenre());
        userEntity.setEmail(newUserEntity.getEmail());

        userRepository.save(userEntity);
    }

    @Override
    public void addImageToUser(String image, Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Film with id[" + id + "] not found!")
        );
        userEntity.setImage(image);
        userRepository.save(userEntity);
    }


}
