package com.hospital.webapp.service;

import com.hospital.webapp.dto.user.UserUpdateDTO;
import com.hospital.webapp.dto.user.UserDTO;
import com.hospital.webapp.entities.User;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();

    Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    User saveUser(User user);

    UserDTO createUser(@NotNull UserUpdateDTO userDTO);

    User updateUser(User user);

    void deleteUserById(Long id);

}

