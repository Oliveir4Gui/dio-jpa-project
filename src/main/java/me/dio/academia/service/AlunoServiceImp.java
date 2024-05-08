package me.dio.academia.service;
import me.dio.academia.entity.AvaliacaoFisica;
import me.dio.academia.entity.form.AlunoForm;
import me.dio.academia.entity.Aluno;
import me.dio.academia.entity.form.AlunoForm;
import me.dio.academia.entity.form.AlunoUpdateForm;
import me.dio.academia.infra.utils.JavaTimeUtils;
import me.dio.academia.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImp  implements IAlunoService{

    @Autowired
    AlunoRepository repository;
    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        return repository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return null;
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        if(dataDeNascimento==null){
            return repository.findAll();
        }else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByDataDeNascimento(localDate);
        }

    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(Long id) {
      Aluno aluno = repository.findById(id).get();
      return aluno.getAvaliacoes();
    }


}
