package com.hospital.webapp.service.impl;

import com.hospital.webapp.dao.UserDAO;
import com.hospital.webapp.dto.user.UserUpdateDTO;
import com.hospital.webapp.dto.user.UserDTO;
import com.hospital.webapp.entities.User;
import com.hospital.webapp.service.UserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getUsers() {
        return userDAO.findAllUsers();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userDAO.findUserById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return userDAO.saveUser(user);
    }

    @Override
    public UserDTO createUser(@NotNull final UserUpdateDTO userDTO) {
//        Objects.requireNonNull(userDTO, "User can't be null");
//        final var user = new User();
//        user.setBirthdate(userDTO.birthdate());
//        user.setEmail(userDTO.email());
//        final User savedUser = userDAO.save(user);
//        return new UserDTO(savedUser.getId(), savedUser.getEmail(), savedUser.getBirthdate());
        return null;
    }

    @Override
    public User updateUser(User user) {
        return userDAO.saveUser(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDAO.deleteUserById(id);
    }

}
