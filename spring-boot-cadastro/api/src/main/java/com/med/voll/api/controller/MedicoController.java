package com.med.voll.api.controller;

import com.med.voll.api.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A classe Controller serve para eu realizar algumas configurações, como por exemplo a anotação @RestController que serve
 * para eu dizer que ela é uma classe Controller e também a anotação @PostMapping onde eu digo qual é o método post e a
 * anotação @Autowired, ela é uma anotação para eu poder usar o Repository do Spring
 */
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoRepository repository;
    @PostMapping("/cadastro")
    @Transactional
    public DadosCadastroMedicos cadastrar(@RequestBody @Valid DadosCadastroMedicos dados){
        repository.save(new MedicoEntidade(dados));
        return dados;
    }

    @GetMapping("/listar")
    public Page<DadosListagemMedico> listar (@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping("/atualizar")
    @Transactional
    public void atualizar (@RequestBody @Valid DadosAtualizacaoMedicos dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarDadosMedico(dados);
    }
}
