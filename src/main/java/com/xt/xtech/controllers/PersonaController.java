package com.xt.xtech.controllers;

import com.xt.xtech.dao.PersonaDAO;
import com.xt.xtech.models.Persona;
import com.xt.xtech.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaDAO personaDAO;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/personas", method = RequestMethod.POST)
    public void createPersona(@RequestBody Persona persona) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, persona.getPassword());
        persona.setPassword(hash);

        personaDAO.createPersona(persona);
    }

    @RequestMapping(value = "api/personas", method = RequestMethod.GET)
    public List<Persona> getPersonas(@RequestHeader(value = "Authorization") String token) {

        String personaId = jwtUtil.getKey(token);
        if (validateToken(token)) return personaDAO.getPersonas();
        return null;

    }

    private boolean validateToken(String token) {

        String personaId = jwtUtil.getKey(token);
        return personaId != null;
    }

    @RequestMapping(value = "api/personas/{id}", method = RequestMethod.DELETE)
    public void deletePersona(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if (validateToken(token)) personaDAO.deletePersona(id);
    }
}
