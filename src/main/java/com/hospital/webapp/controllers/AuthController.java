package com.hospital.webapp.controllers;
/*
import com.project.appweb.dao.UserDao;
import com.project.appweb.models.User;
import com.project.appweb.utils.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping(value = "api/login")
    public String logIn(@RequestBody User user){
        User userLogged = userDao.getUserByCredentials(user);
        if (userLogged != null) {
            // if an authenticated error is found, it means it's a 401 error
            return jwtUtil.create(String.valueOf(userLogged.getId()), userLogged.getEmail()); // return the jwt token
        }
        return "FAIL";
    }

}
*/