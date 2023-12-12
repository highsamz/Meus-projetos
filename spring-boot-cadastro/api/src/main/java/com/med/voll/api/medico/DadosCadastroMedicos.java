package com.med.voll.api.medico;

import com.med.voll.api.endereco.DadosEnderecoMedico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 *
 * @param email
 * @param telefone
 * @param crm
 * @param especialidade
 * @param endereco
 */
public record DadosCadastroMedicos(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        EspecialidadeEnum especialidade,

        @NotNull
        @Valid
        DadosEnderecoMedico endereco) {
}
