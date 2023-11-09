package com.example.reto.adapter;

import com.example.reto.application.dto.PersonDTO;
import com.example.reto.application.service.PersonService;
import com.example.reto.domain.mapper.ResponseMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity getPersonAll() {
        return ResponseMapper.buildCustomResponse(200, "ok", personService.getAll());
    }

    @PostMapping
    public ResponseEntity createPerson(@RequestBody @Valid PersonDTO personDTO) {
        personService.save(personDTO);
        return ResponseMapper.buildCustomResponse(201, "ok");
    }

    @GetMapping("/dni")
    public ResponseEntity getPersonOrderByDni(@RequestParam(defaultValue = "asc") String order) {
        return ResponseMapper.buildCustomResponse(200, "ok", personService.getListByDni(order));
    }

    @GetMapping("lastname")
    public ResponseEntity getPersonOrderByLastName(@RequestParam(defaultValue = "asc") String order) {
        return ResponseMapper.buildCustomResponse(200, "ok", personService.getListByLastName(order));
    }
}
