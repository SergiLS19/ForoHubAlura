package com.alura.foroHub.domain.response.repo;

import com.alura.foroHub.domain.response.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RepoRespuesta extends JpaRepository<Respuesta,Long> {
    Page<Respuesta> findAllByTopicoId(Long topicoId, Pageable pageable);

    Page<Respuesta> findAllByUsuarioId(Long usuarioId, Pageable pageable);

    Respuesta getReferenceByTopicoId(Long id);

    @SuppressWarnings("null")
    Respuesta getReferenceById(Long id);
}
