package com.med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record DadosEnderecoPaciente(

        @NotBlank
        String rua,

        @NotBlank
        String numero,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        String complemento
) {
}
