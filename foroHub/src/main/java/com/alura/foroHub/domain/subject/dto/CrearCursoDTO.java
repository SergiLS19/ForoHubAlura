package com.alura.foroHub.domain.subject.dto;

import com.alura.foroHub.domain.subject.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearCursoDTO(@NotBlank String nombre, @NotNull Categoria categoria) {


}
