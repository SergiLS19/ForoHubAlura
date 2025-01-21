package com.alura.foroHub.domain.response.validations.create;

import com.alura.foroHub.domain.response.dto.CrearRespuestaDTO;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class RespuestaDelUsuarioValida implements ValidarRespuesta{
    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validar(CrearRespuestaDTO data) {
        var usuarioExiste = repository.existsById(data.usuarioId());

        if(!usuarioExiste){
            throw new ValidationException("Este usuario no existe");
        }

        var usuarioHabilitado = repository.findById(data.usuarioId()).get().isEnabled();

        if(!usuarioHabilitado){
            throw new ValidationException("Este usuario no esta habilitado");
        }
    }
}
