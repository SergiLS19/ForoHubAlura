package com.alura.foroHub.domain.subject.dto;

import com.alura.foroHub.domain.subject.Categoria;

public record ActualizarCursoDTO(String nombre, Categoria categoria, Boolean activo) {
}
