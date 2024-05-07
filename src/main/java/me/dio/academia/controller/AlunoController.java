package me.dio.academia.controller;

import me.dio.academia.entity.Aluno;
import me.dio.academia.entity.form.AlunoForm;
import me.dio.academia.service.AlunoServiceImp;
import me.dio.academia.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoServiceImp service;

    @GetMapping
    public List<Aluno> getall(){
    return service.getAll();
    }

    @PostMapping
    public Aluno create(@RequestBody AlunoForm form) {
     return service.create(form);
    }

}
