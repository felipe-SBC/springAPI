package com.fatec.Projeto.model;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface iProdutoRepository extends JpaRepository<Produto, Long> {
    public List<Produto> findAllByDescricaoIgnoreCaseContaining(String descricao);
}
