package com.alura.foroHub.domain.response.validations.create;

import com.alura.foroHub.domain.response.dto.CrearRespuestaDTO;
import org.springframework.stereotype.Component;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class RespuestaTopicoValido implements ValidarRespuesta{
    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(CrearRespuestaDTO data) {
        var topicoExiste = repository.existsById(data.topicoId());

        if (!topicoExiste){
            throw new ValidationException("Este topico no existe.");
        }

        var topicoAbierto = repository.findById(data.topicoId()).get().getEstado();

        if(topicoAbierto != Estado.OPEN){
            throw new ValidationException("Este topico no esta abierto.");
        }

    }
}
