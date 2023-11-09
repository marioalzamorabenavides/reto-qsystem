package com.example.reto.application.service;

import com.example.reto.application.dto.PersonDTO;
import com.example.reto.domain.model.Person;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonService {
    List<PersonDTO> getAll();

    void save(PersonDTO person);

    List<PersonDTO> getListByDni(String order);

    List<PersonDTO> getListByLastName(String order);
}
