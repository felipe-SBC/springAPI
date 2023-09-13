package com.fatec.Projeto.service;

import com.fatec.Projeto.model.Catalogo;
import com.fatec.Projeto.model.Imagem;
import com.fatec.Projeto.model.Produto;
import com.fatec.Projeto.model.iProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServico implements IProdutoServico{
    @Autowired
    iProdutoRepository repositoryP;
    @Autowired
    ImagemServico imagemServico;
    public List<Catalogo> consultaCatalogo() {

        Catalogo c = null;
        List<Catalogo> lista = new ArrayList<Catalogo>();
        List<Produto> listaP = repositoryP.findAll();
        List<Imagem> listaI = imagemServico.getAll();
        for (Produto p : listaP) {
            for (Imagem i : listaI) {
                if (p.getId().equals(i.getId())) {
                    c = new Catalogo(p.getId(), p.getDescricao(), p.getCategoria(),
                            p.getCusto(),p.getQuantidadeNoEstoque(), i.getArquivo());
                    lista.add(c);
                }
            }
        }
        return lista;
    }
}
