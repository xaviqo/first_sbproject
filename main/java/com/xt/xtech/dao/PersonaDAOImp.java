package com.xt.xtech.dao;

import com.xt.xtech.models.Persona;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonaDAOImp implements PersonaDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Persona> getPersonas() {
        String query = "FROM Persona";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deletePersona(Long id) {
        Persona persona = entityManager.find(Persona.class, id);
        entityManager.remove(persona);
    }

    @Override
    public void createPersona(Persona persona) {
        entityManager.merge(persona);
    }

    @Override
    public Persona getUserByCredentials(Persona persona) {
        String query = "FROM Persona WHERE email = :email";
        List<Persona> personaToCheck = entityManager.createQuery(query)
                .setParameter("email", persona.getEmail())
                .getResultList();

        if (personaToCheck.isEmpty()) {
            return null;
        }
        String hashedPwd = personaToCheck.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(hashedPwd, persona.getPassword())) {
            return personaToCheck.get(0);
        }

        return null;
    }
}
