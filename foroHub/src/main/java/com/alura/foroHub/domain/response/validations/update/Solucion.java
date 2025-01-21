package com.alura.foroHub.domain.response.validations.update;

import com.alura.foroHub.domain.response.Respuesta;
import com.alura.foroHub.domain.response.dto.ActualizarRespuestaDTO;
import com.alura.foroHub.domain.response.repo.RepoRespuesta;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Solucion implements ValidarRespuestaActualizada
{
    @Autowired
    private RepoRespuesta repoRespuesta;

    @Autowired
    private RepoTopico repoTopico;

    @Override
    public void validate(ActualizarRespuestaDTO data, Long respuestaId) {
        if (data.solucion()){
            Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
            var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
            if (topicoResuelto.getEstado() == Estado.CLOSED){
                throw new ValidationException("Este topico ya fue solucionado.");
            }
        }
    }
}
