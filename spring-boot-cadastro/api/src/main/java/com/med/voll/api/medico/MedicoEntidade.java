package com.med.voll.api.medico;

import com.med.voll.api.endereco.EntidadeEnderecoMedico;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoEntidade {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Boolean status;
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade;

    @Embedded
    private EntidadeEnderecoMedico endereco;

    public MedicoEntidade(DadosCadastroMedicos dados) {
        this.status = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new EntidadeEnderecoMedico(dados.endereco());

    }

    public void atualizarDadosMedico(DadosAtualizacaoMedicos dados) {

        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.email() != null){
            this.email = dados.email();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null){
            this.endereco.atualizarEnderecoMedico(dados.endereco());
        }



    }
}
