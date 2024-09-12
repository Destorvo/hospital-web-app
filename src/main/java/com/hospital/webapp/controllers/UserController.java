package com.hospital.webapp.controllers;

import com.hospital.webapp.dto.user.UserDTO;
import com.hospital.webapp.dto.user.UserExampleDTO;
import com.hospital.webapp.dto.user.UserUpdateDTO;
import com.hospital.webapp.entities.Roles;
import com.hospital.webapp.entities.User;
import com.hospital.webapp.repositories.RolRepository;
import com.hospital.webapp.repositories.UserRepository;
import com.hospital.webapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final RolRepository rolRepository;

    @Autowired
    private UserRepository userRepository;

    public UserController(UserService userService, RolRepository rolRepository) {
        this.userService = userService;
        this.rolRepository = rolRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<User> searchUserEmail(@RequestParam("email") String email) {
        return userService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result) {
        if(result.hasErrors())
            //return ResponseEntity.badRequest().body(result.getAllErrors());
            return ResponseEntity.badRequest().build();
        else {
            User savedUser = userService.saveUser(user);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedUser.getId())
                    .toUri();
            return ResponseEntity.created(location).body(savedUser);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO userUpdateDTO) {
        Optional<User> existentUser = userService.getUserById(id);
        if (existentUser.isEmpty())
            return ResponseEntity.notFound().build();

        Roles role = rolRepository.findById(userUpdateDTO.getRolId()).orElse(null);
        if (role == null)
            return ResponseEntity.notFound().build();
        User user = existentUser.get();
        user.setName(userUpdateDTO.getName());
        user.setSurname(userUpdateDTO.getSurname());
        user.setEmail(userUpdateDTO.getEmail());
        user.setPassword(userUpdateDTO.getPassword());
        user.setPhoneNumber(userUpdateDTO.getPhoneNumber());
        user.setRole(role);
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(u -> {
                    userService.deleteUserById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/xd")
    public List<UserExampleDTO> findDTO() {
        return userRepository.findUserBy();
    }

}
