package br.com.fiap.microservices.catalogoservice.service;

import br.com.fiap.microservices.catalogoservice.model.Produto;
import br.com.fiap.microservices.catalogoservice.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoService.class);
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto criarPorduto(Produto produto) {
        logger.info("Criando produto: {}", produto.getNome());
        return produtoRepository.save(produto);
    }

    public Produto buscarProduto(Long id){
        logger.info("Buscando produto com id: {}", id);
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
    }

    public List<Produto> listarProdutos(){
        logger.info("Listando todos os produtos");
        return produtoRepository.findAll();
    }

}
