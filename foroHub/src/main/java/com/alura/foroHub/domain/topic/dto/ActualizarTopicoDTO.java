package com.alura.foroHub.domain.topic.dto;

import com.alura.foroHub.domain.topic.Estado;

public record ActualizarTopicoDTO(String titulo, String mensaje, Estado estado, Long cursoId) {
}
