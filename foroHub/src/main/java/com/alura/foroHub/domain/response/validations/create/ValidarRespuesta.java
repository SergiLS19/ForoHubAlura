package com.alura.foroHub.domain.response.validations.create;

import com.alura.foroHub.domain.response.dto.CrearRespuestaDTO;

public interface ValidarRespuesta {
    void validate(CrearRespuestaDTO datos);
}
