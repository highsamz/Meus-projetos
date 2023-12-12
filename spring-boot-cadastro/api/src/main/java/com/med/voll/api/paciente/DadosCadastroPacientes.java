package com.med.voll.api.paciente;

import com.med.voll.api.endereco.DadosEnderecoPaciente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPacientes(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String documento,

        @NotBlank
        String telefone,

        @NotNull
        @Valid
        DadosEnderecoPaciente enderecop) {
}
