package me.dio.academia.controller;

import me.dio.academia.entity.Matricula;
import me.dio.academia.entity.form.MatriculaForm;

import me.dio.academia.service.MatriculaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    @Autowired
     private MatriculaServiceImp service;

    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro",required = false)String bairro){
        return service.getAll(bairro);
    }

    @PostMapping
    public Matricula create(@RequestBody MatriculaForm form){
        return service.create(form);
    }
}
