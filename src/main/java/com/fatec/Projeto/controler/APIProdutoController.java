package com.fatec.Projeto.controler;

import com.fatec.Projeto.service.IProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/produtos")
public class APIProdutoController {
    @Autowired
    IProdutoServico produtoServico;
    @CrossOrigin
    @GetMapping
    public ResponseEntity<Object> consultaTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoServico.consultaCatalogo());
    }
}
