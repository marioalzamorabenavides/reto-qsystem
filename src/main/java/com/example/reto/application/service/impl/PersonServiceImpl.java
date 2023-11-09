package com.example.reto.application.service.impl;

import com.example.reto.application.dto.PersonDTO;
import com.example.reto.application.service.PersonService;
import com.example.reto.domain.mapper.PersonMapper;
import com.example.reto.domain.model.Person;
import com.example.reto.infrastructure.persistence.PersonRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonDTO> getAll() {
        try {
            return PersonMapper.convertToDTO(personRepository.findAll());
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public void save(PersonDTO person) {
        try {
            personRepository.save(Person.builder()
                    .dni(person.dni())
                    .nombres(person.nombres())
                    .appPaterno(person.apellidoPaterno())
                    .appMatterno(person.apellidoMaterno())
                    .build());
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public List<PersonDTO> getListByDni(String order) {
        try {
            Sort sort = Sort.by(order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, "dni");
            return PersonMapper.convertToDTO(personRepository.getListByDni(sort));
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public List<PersonDTO> getListByLastName(String order) {
        try {
            Sort sort = Sort.by(order.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, "appPaterno");
            return PersonMapper.convertToDTO(personRepository.getListByLastName(sort));
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
