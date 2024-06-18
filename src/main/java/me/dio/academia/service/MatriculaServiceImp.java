package me.dio.academia.service;

import me.dio.academia.entity.Aluno;
import me.dio.academia.entity.Matricula;
import me.dio.academia.entity.form.MatriculaForm;
import me.dio.academia.repository.AlunoRepository;
import me.dio.academia.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class MatriculaServiceImp implements IMatriculaService {

    @Autowired
    MatriculaRepository repository;
    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
       Matricula matricula = new Matricula();
       Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
       matricula.setAluno(aluno);
       return repository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll() {
      return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }



}
