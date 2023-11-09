package com.example.reto.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "person")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 8)
    private String dni;

    @Column(name = "nombres", length = 150, nullable = false)
    private String nombres;

    @Column(name = "apellido_paterno", length = 150, nullable = false)
    private String appPaterno;

    @Column(name = "apellido_materno", length = 150, nullable = false)
    private String appMatterno;
}
