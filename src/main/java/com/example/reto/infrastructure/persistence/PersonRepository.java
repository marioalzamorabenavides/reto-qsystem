package com.example.reto.infrastructure.persistence;

import com.example.reto.domain.model.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT p FROM Person p")
    List<Person> getListByDni(Sort sort);

    @Query("SELECT p FROM Person p")
    List<Person> getListByLastName(Sort sort);
}