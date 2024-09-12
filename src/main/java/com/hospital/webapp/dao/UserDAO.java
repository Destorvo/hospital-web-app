package com.hospital.webapp.dao;

import com.hospital.webapp.dto.user.UserDTO;
import com.hospital.webapp.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<User> findAllUsers();

    Optional<User> findUserById(Long id);

    Optional<User> findUserByEmail(String email);

    User saveUser(User user);

    void deleteUserById(Long id);

}

