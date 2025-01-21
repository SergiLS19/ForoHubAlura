package com.alura.foroHub.domain.subject.repo;

import com.alura.foroHub.domain.subject.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Repository
public interface RepoCurso extends JpaRepository<Curso,Long> {
    Page<Curso> findAllByActivoTrue(Pageable pageable);
}
