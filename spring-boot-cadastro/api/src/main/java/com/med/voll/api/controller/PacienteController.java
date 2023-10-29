package com.med.voll.api.controller;

import com.med.voll.api.paciente.DadosCadastroPacientes;
import com.med.voll.api.paciente.PacienteEntidade;
import com.med.voll.api.paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro")
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    @PostMapping("/pacientes")
    @Transactional
    public DadosCadastroPacientes cadastroPaciente(@RequestBody @Valid DadosCadastroPacientes dados) {
        repository.save(new PacienteEntidade(dados));
        return dados;
    }

    @GetMapping("/pacientes/listar")
    public void listagemPaciente(){

    }
}
