package com.fatec.Projeto.service;

import com.fatec.Projeto.model.Imagem;
import com.fatec.Projeto.model.Produto;
import com.fatec.Projeto.model.iImagemRepository;
import com.fatec.Projeto.model.iProdutoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Configuration
public class LoadDatabase {
    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    iImagemRepository imagemRepository;
    @Bean
    CommandLineRunner initDatabase(iProdutoRepository repository) {
        return args -> {
            Produto produto1 = new Produto("Eletrobomba 110V para Maquina de Lavar e Lava Louças", "maquina de lavar", 51.66, 12);
            Produto produto2 = new Produto("Tirante Original Brastemp E Consul De 7 A 12 Kg 11cm","lavar louça", 3.90,20);
            Produto produto3 = new Produto("Termoatuador Lavadora Colormaq Electrolux GE","maquina de lavar", 29.70,40);
            repository.saveAll(Arrays.asList(produto1, produto2, produto3));
            logger.info (">>>>> loaddatabase -> 3 produtos cadastrados no db.");
            //****************************************************************
            //upload - obtem a imagem do c, atribui ao obj imagem e salva no db do servidor
            //****************************************************************
            Path path = Paths.get("C:\\Users\\aluno\\Documents\\img/produto1.jpg");
            InputStream file = Files.newInputStream(path);
            byte[] arquivo1 = file.readAllBytes();
            Imagem imagem = new Imagem();
            imagem.setId(1L); // associa o id do produto ao id da imagem
            imagem.setNome("produto1.jpg");
            imagem.setCaminho("imagens/" + imagem.getNome());
            imagem.setArquivo(arquivo1);
            logger.info (">>>>> loaddatabase -> upload de arquivo imagem realizado => " + arquivo1.length);
            imagemRepository.save(imagem);
            //****************************************************************
            path = Paths.get("C:\\Users\\aluno\\Documents\\img/produto2.jpg");
            file= Files.newInputStream(path);
            byte[] arquivo2 = file.readAllBytes();
            imagem = new Imagem();
            imagem.setId(2L); // associa o id do produto ao id da imagem
            imagem.setNome("produto2.jpg");
            imagem.setCaminho("imagens/" + imagem.getNome());
            imagem.setArquivo(arquivo2);
            logger.info (">>>>> loaddatabase -> upload de arquivo imagem realizado => " + arquivo2.length);
            imagemRepository.save(imagem);
            //****************************************************************
            path = Paths.get("C:\\Users\\aluno\\Documents\\img/produto3.jpg");
            file= Files.newInputStream(path);
            byte[] arquivo3 = file.readAllBytes();
            imagem = new Imagem();
            imagem.setId(3L); // associa o id do produto ao id da imagem
            imagem.setNome("produto3.jpg");
            imagem.setCaminho("imagens/" + imagem.getNome());
            imagem.setArquivo(arquivo3);
            logger.info (">>>>> loaddatabase -> upload de arquivo imagem realizado => " + arquivo3.length);
            imagemRepository.save(imagem);
        };
    }

}
