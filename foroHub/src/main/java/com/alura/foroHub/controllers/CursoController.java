package com.alura.foroHub.controllers;

import com.alura.foroHub.domain.subject.Curso;
import com.alura.foroHub.domain.subject.dto.CrearCursoDTO;
import com.alura.foroHub.domain.subject.dto.ActualizarCursoDTO;
import com.alura.foroHub.domain.subject.dto.DetalleDeCursoDTO;
import com.alura.foroHub.domain.subject.repo.RepoCurso;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name="bearer-key")
@Tag(name="Curso", description="Puede que pertenezca a alguna de las categorias")
public class CursoController {
    @Autowired
    private RepoCurso repoCurso;
    @PostMapping
    @Transactional
    @Operation(summary = "Registrar nuevo curso en base de datos")
    public ResponseEntity<DetalleDeCursoDTO> crearTopico(@RequestBody @Valid CrearCursoDTO crearCursoDTO,
                                                       UriComponentsBuilder uriBuilder){
        Curso curso = new Curso(crearCursoDTO);
        repoCurso.save(curso);
        var uri = uriBuilder.path("/cursos/{i}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalleDeCursoDTO(curso));

    }

    @GetMapping("/all")
    @Operation(summary = "Lee todos los cursos segun estado")
    public ResponseEntity<Page<DetalleDeCursoDTO>> listarCursos(@PageableDefault(size = 5, sort = {"id"}) Pageable pageable){
        var pagina = repoCurso.findAll(pageable).map(DetalleDeCursoDTO::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping
    @Operation(summary = "Lista de cursos activos")
    public ResponseEntity<Page<DetalleDeCursoDTO>> listarCursosActivos(@PageableDefault(size = 5, sort = {"id"}) Pageable pageable){
        var pagina = repoCurso.findAllByActivoTrue(pageable).map(DetalleCursoDTO::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lee un solo curso por su ID")
    public ResponseEntity<DetalleDeCursoDTO> ListarUnCurso(@PathVariable Long id){
        Curso curso = repoCurso.getReferenceById(id);
        var datosDelCurso = new DetalleDeCursoDTO(
                curso.getId(),
                curso.getName(),
                curso.getCategoria(),
                curso.getActivo()
        );
        return ResponseEntity.ok(datosDelCurso);
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Actualiza el nombre, la categoría o el estado de un curso")
    public ResponseEntity<DetalleDeCursoDTO> actualizarCurso(@RequestBody @Valid ActualizarCursoDTO actualizarCursoDTO, @PathVariable Long id){

        Curso curso = repoCurso.getReferenceById(id);

        curso.actualizarCurso(actualizarCursoDTO);

        var datosDelCurso = new DetalleDeCursoDTO(
                curso.getId(),
                curso.getName(),
                curso.getCategoria(),
                curso.getActivo()
        );
        return ResponseEntity.ok(datosDelCurso);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Elimina un curso")
    public ResponseEntity<?> eliminarCurso(@PathVariable Long id){
        Curso curso = repoCurso.getReferenceById(id);
        curso.eliminarCurso();
        return ResponseEntity.noContent().build();
    }
}
