package com.fatec.Projeto.service;

import com.fatec.Projeto.model.Produto;
import com.fatec.Projeto.model.iProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServico implements IProdutoServico{
    @Autowired
    iProdutoRepository repository;

    @Override
    public List<Produto> consultaCatalogo(){
        return repository.findAll();
    }
}
