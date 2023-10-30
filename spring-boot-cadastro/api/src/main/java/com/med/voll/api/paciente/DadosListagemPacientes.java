package com.med.voll.api.paciente;

import com.med.voll.api.medico.DadosListagemMedico;
import com.med.voll.api.medico.MedicoEntidade;

public record DadosListagemPacientes(Long id, String nome, String email, String telefone) {

    public DadosListagemPacientes(PacienteEntidade pacienteEntidade){
        this(pacienteEntidade.getId(),
                pacienteEntidade.getNome(),
                pacienteEntidade.getEmail(),
                pacienteEntidade.getTelefone());
    }
}
