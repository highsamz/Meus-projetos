package com.med.voll.api.controller;

import com.med.voll.api.paciente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    @PostMapping("/cadastro")
    @Transactional
    public DadosCadastroPacientes cadastroPaciente(@RequestBody @Valid DadosCadastroPacientes dados) {
        repository.save(new PacienteEntidade(dados));
        return dados;
    }

    @GetMapping("/listar")
    public Page<DadosListagemPacientes> listagemPaciente(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByStatusTrue(paginacao).map(DadosListagemPacientes::new);
    }

    @PutMapping("/atualizar")
    @Transactional
    public void atualizacaoPaciente (@RequestBody @Valid DadosAtualizacaoPaciente dados){
        var pacienteEntidade = repository.getReferenceById(dados.id());
        pacienteEntidade.atualizarDadosPaciente(dados);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarPaciente(@PathVariable Long id){
        var pacienteEntidade = repository.getReferenceById(id);
        pacienteEntidade.excluirPaciente();
    }
}
