package com.med.voll.api.medico;

public record DadosListagemMedico (String nome, String email, String crm, EspecialidadeEnum especialidade) {

    public DadosListagemMedico(MedicoEntidade medico){

        this(medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getEspecialidade());
    }
}
