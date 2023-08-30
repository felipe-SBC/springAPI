package com.fatec.Projeto.service;

import com.fatec.Projeto.model.Produto;
import com.fatec.Projeto.model.iProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(iProdutoRepository repository){
        return args -> {
          Produto produto1 = new Produto("Tirante Brastemp", "Maquina de Lavar", 51.66, 14);
          repository.saveAll(Arrays.asList(produto1));
        };
    }
}
