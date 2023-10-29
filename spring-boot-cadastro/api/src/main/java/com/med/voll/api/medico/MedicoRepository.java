package com.med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Essa interface serve para eu extender os métodos da Classe JpaRepository e toda a sua hierarquia
 * Nela eu passo a entidade que é médigo e a chave primaria que é do tipo Long. Posteriormente vou chamala na classe
 * executavel e usar o método save
 */
public interface MedicoRepository extends JpaRepository <MedicoEntidade, Long> {
}
