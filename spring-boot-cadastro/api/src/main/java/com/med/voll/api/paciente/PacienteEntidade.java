package com.med.voll.api.paciente;


import com.med.voll.api.endereco.EnderecoEntidadePaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Pacientes")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PacienteEntidade {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String documento;
    private String telefone;

    @Embedded
    private EnderecoEntidadePaciente endereco;

    public PacienteEntidade(DadosCadastroPacientes dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.documento = dados.documento();
        this.telefone = dados.telefone();
        this.endereco = new EnderecoEntidadePaciente(dados.enderecop());
    }
}
