package me.dio.academia.repository;

import me.dio.academia.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    @Query("FROM Matricula m WHERE m.aluno.bairro = :bairro")
    List<Matricula> findMatriculaByAluno_Bairro(String bairro);

}
