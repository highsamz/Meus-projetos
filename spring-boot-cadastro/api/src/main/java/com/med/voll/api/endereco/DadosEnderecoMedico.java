package com.med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 *
 * @param logradouro
 * @param bairro
 * @param cep
 * @param cidade
 * @param uf
 * @param numero
 * @param complemento
 * DTO para receber as informações recebidas da requisição e posteriormente salvar no banco
 */
public record DadosEnderecoMedico(
        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        String numero,

        String complemento) {}