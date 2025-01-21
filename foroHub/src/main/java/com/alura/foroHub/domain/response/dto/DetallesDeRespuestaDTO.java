package com.alura.foroHub.domain.response.dto;

import com.alura.foroHub.domain.response.Respuesta;

import java.time.LocalDateTime;

public record DetallesDeRespuestaDTO (Long id,
                                      String mensaje,
                                      LocalDateTime fechaCreacion,
                                      LocalDateTime ultimaActualizacion,
                                      Boolean solucion,
                                      Boolean borrado,
                                      Long usuarioId,
                                      String username,
                                      Long topicoId,
                                      String topico){
    public DetalleRespuestaDTO(Respuesta respuesta){
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getUltimaActualizacion(),
                respuesta.getSolucion(),
                respuesta.getBorrado(),
                respuesta.getUsuario().getId(),
                respuesta.getUsuario().getUsername(),
                respuesta.getTopico().getId(),
                respuesta.getTopico().getTitulo());
    }
}
