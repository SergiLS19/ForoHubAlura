package com.alura.foroHub.domain.subject.dto;

import com.alura.foroHub.domain.subject.Categoria;
import com.alura.foroHub.domain.subject.Curso;



public record DetalleDeCursoDTO(Long id,
        String nombre,
        Categoria categoria,
        Boolean activo) {
    public DetalleDeCursoDTO(Curso curso){
        this.id=curso.getId();
        this.nombre=curso.getNombre();
        this.categoria=curso.getCategoria();
        this.activo=curso.getActivo();

    }

}
