package com.med.voll.api.paciente;


import com.med.voll.api.endereco.DadosEnderecoPaciente;
import com.med.voll.api.endereco.EnderecoEntidadePaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PacienteEntidade {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean status;
    private String nome;
    private String email;
    private String documento;
    private String telefone;

    @Embedded
    private EnderecoEntidadePaciente endereco;

    public PacienteEntidade(DadosCadastroPacientes dados){
        this.status = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.documento = dados.documento();
        this.telefone = dados.telefone();
        this.endereco = new EnderecoEntidadePaciente(dados.enderecop());
    }

    public void atualizarDadosPaciente(DadosAtualizacaoPaciente dados) {

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
            this.endereco.atualizarDadosPaciente(dados.endereco());
        }

    }

    public void excluirPaciente() {
        this.status = false;
        System.out.println("Funcionou a deleção");
    }
}
