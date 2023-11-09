package com.example.reto.domain.mapper;

import com.example.reto.application.dto.PersonDTO;
import com.example.reto.domain.model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonMapper {
    public static List<PersonDTO> convertToDTO(List<Person> list) {
        return list.stream().map(x -> new PersonDTO(
                x.getDni(),
                x.getNombres(),
                x.getAppPaterno(),
                x.getAppMatterno()
        )).collect(Collectors.toList());
    }
}
