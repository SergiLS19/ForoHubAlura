package com.alura.foroHub.domain.response.validations.update;

import com.alura.foroHub.domain.response.dto.ActualizarRespuestaDTO;

public interface ValidarRespuestaActualizada {
    void validar(ActualizarRespuestaDTO data, Long respuestaId);
}
