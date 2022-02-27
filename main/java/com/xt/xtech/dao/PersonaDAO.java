package com.xt.xtech.dao;

import com.xt.xtech.models.Persona;

import java.util.List;

public interface PersonaDAO {

    List<Persona> getPersonas();

    void deletePersona(Long id);

    void createPersona(Persona persona);

    Persona getUserByCredentials(Persona persona);
}
