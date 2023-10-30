package com.med.voll.api.medico;

import com.med.voll.api.endereco.DadosEnderecoMedico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedicos(
        @NotNull
        Long id,

        String nome,

        String email,

        String telefone,

        DadosEnderecoMedico endereco) {
}
