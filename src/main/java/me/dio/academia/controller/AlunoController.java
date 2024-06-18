package me.dio.academia.controller;

import jakarta.validation.Valid;
import me.dio.academia.entity.Aluno;
import me.dio.academia.entity.AvaliacaoFisica;
import me.dio.academia.entity.form.AlunoForm;
import me.dio.academia.entity.form.AlunoUpdateForm;
import me.dio.academia.service.AlunoServiceImp;
import me.dio.academia.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoServiceImp service;

    @GetMapping
    public List<Aluno> getall(@RequestParam(value = "dataDeNascimento",required = false) String dataDeNascimento){
    return service.getAll(dataDeNascimento);
    }

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form) {
     return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable Long id){
    return service.getAllAvaliacaoFisica(id);
    }

    @PutMapping("/{id}")
    public Aluno update(@PathVariable Long id, @RequestBody AlunoUpdateForm form){
        service.update(id, form);
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
