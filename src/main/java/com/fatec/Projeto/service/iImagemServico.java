package com.fatec.Projeto.service;
import com.fatec.Projeto.model.Imagem;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface iImagemServico {
    public Optional<Imagem> salvar(MultipartFile imagem, Long id) throws IOException;
    public List<Imagem> getAll();
    public byte[] getImagem (String nomeArquivo);
    public byte[] getImagemById(Long id);
}