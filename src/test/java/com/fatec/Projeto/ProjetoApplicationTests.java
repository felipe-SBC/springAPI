package com.fatec.Projeto;

import com.fatec.Projeto.model.Catalogo;
import com.fatec.Projeto.model.Produto;
import com.fatec.Projeto.service.IProdutoServico;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProjetoApplicationTests {

	@Autowired
	IProdutoServico produtoServico;

	@Test
	void contextLoads() {
	}

	@Test
	void ct01_verifica_custo(){
		Produto produto = new Produto();
		produto.setCusto(12);
		assertEquals(12, produto.getCusto());
	}

	@Test
	void ct02_consulta_com_sucesso(){
		List<Catalogo> produtos = produtoServico.consultaCatalogo();
		assertEquals(0,produtos.size());
	}
}
