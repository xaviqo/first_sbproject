package com.xt.xtech.controllers;

import com.xt.xtech.dao.PersonaDAO;
import com.xt.xtech.models.Persona;
import com.xt.xtech.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private PersonaDAO personaDAO;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String logIn(@RequestBody Persona persona) {

        Persona authUser = personaDAO.getUserByCredentials(persona);

        if (authUser != null) {

            return jwtUtil.create(String.valueOf(authUser.getId()), authUser.getEmail()); //returns the created JWT token

        } else {

            return "FAIL";

        }
    }
}
