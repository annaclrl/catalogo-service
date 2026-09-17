package br.com.fiap.microservices.catalogoservice.controller;

import br.com.fiap.microservices.catalogoservice.model.Produto;
import br.com.fiap.microservices.catalogoservice.service.ProdutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog/produtos")
public class ProdutoController {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto){
        logger.info("POST /api/catalog/produtos - Produto: {}", produto.getNome());
        Produto produtoCriado = produtoService.criarPorduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id){
        logger.info("GET /api/catalog/produtos/{}", id);
        return ResponseEntity.ok(produtoService.buscarProduto((id)));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar(){
        logger.info("GET /api/catalog/produtos");
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

}
