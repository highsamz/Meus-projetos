package com.med.voll.api.paciente;

import com.med.voll.api.endereco.DadosEnderecoPaciente;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        DadosEnderecoPaciente endereco) {
}
