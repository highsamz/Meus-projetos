package com.med.voll.api.endereco;

import com.med.voll.api.endereco.DadosEnderecoPaciente;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntidadePaciente {

    private String rua;
    private String numero;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;

    public EnderecoEntidadePaciente(DadosEnderecoPaciente dados){
        this.rua = dados.rua();
        this.numero = dados.numero();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.complemento = dados.complemento();
    }
}
