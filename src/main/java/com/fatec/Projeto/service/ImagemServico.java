package com.fatec.Projeto.service;

import com.fatec.Projeto.model.Imagem;
import com.fatec.Projeto.model.Produto;
import com.fatec.Projeto.model.iImagemRepository;
import com.fatec.Projeto.model.iProdutoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ImagemServico implements iImagemServico{

    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    private iImagemRepository imagemRepository;
    @Autowired
    private iProdutoRepository produtoRepository;

    @Override
    public Optional<Imagem> salvar(MultipartFile arquivo, Long id) throws IOException {
        // **********************************************************
        // Obter informações sobre o arquivo - espera um tipo formdata chave/file
        // **********************************************************
        logger.info(">>>>>> servico salvar imagem - iniciado...");
        Optional<Produto> p = produtoRepository.findById(id);
        if (p.isPresent()) {
            logger.info(">>>>>> servico salvar imagem - produto encontrado");
            String nome = arquivo.getOriginalFilename();
            Path caminhoArquivo = Paths.get("imagens/" + nome);
            logger.info(">>>>>> servico salvar imagem - caminho arquivo => " + caminhoArquivo);
            Imagem imagem = new Imagem();
            imagem.setId(id); // associa o id do produto ao id da imagem
            imagem.setNome(arquivo.getOriginalFilename());
            imagem.setCaminho(caminhoArquivo.toString());
            imagem.setArquivo(arquivo.getBytes());
            logger.info(">>>>>> servico salvar imagem - arquivo getSize => " + arquivo.getSize());
            // **********************************************************
            // salva no disco e no db
            // ***********************************************************
            //Files.write(caminhoArquivo, arquivo.getBytes());
            return Optional.of(imagemRepository.save(imagem));
        } else {
            logger.info(">>>>>> servico salvar imagem - id nao encontrado");
            return Optional.empty();
        }
    }


    @Override
    public List<Imagem> getAll() {
        return imagemRepository.findAll();
    }

    @Override
    public byte[] getImagem(String nomeArquivo) {
        return new byte[0];
    }

    @Override
    public byte[] getImagemById(Long id) {
        return new byte[0];
    }
}
