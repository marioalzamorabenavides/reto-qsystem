package com.example.reto.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PersonDTO(
        @NotBlank
        @NotNull
        String dni,
        String nombres,
        String apellidoPaterno,
        String apellidoMaterno
) { }
