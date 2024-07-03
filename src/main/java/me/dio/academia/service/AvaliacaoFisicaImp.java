package me.dio.academia.service;

import me.dio.academia.entity.Aluno;
import me.dio.academia.entity.AvaliacaoFisica;
import me.dio.academia.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.repository.AlunoRepository;
import me.dio.academia.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaImp implements IAvaliacaoFisicaService{
    @Autowired
    AvaliacaoFisicaRepository repository;
    @Autowired
    AlunoRepository alunoRepository;
    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
        AvaliacaoFisica avaliacao =new AvaliacaoFisica();


        avaliacao.setAluno(aluno);
        avaliacao.setPeso(form.getPeso());
        avaliacao.setAltura(form.getAltura());

      return  repository.save(avaliacao);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
       return repository.findById(id).orElse(null);


    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return  repository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
