package me.dio.academia.controller;

import me.dio.academia.entity.AvaliacaoFisica;
import me.dio.academia.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.service.AvaliacaoFisicaImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
    @Autowired
    private AvaliacaoFisicaImp service;

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {

     return service.create(form);
    }

}
