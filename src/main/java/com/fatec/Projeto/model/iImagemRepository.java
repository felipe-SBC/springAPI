package com.fatec.Projeto.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iImagemRepository extends JpaRepository <Imagem, Long> {
    Optional<Imagem> findByNome(String nome);


}
