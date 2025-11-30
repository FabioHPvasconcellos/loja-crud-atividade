package com.suauniversidade.lojacrud.service;

import com.suauniversidade.lojacrud.model.Produto;
import com.suauniversidade.lojacrud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // 1. Cadastro (Create)
    public Produto salvarProduto(Produto produto) {
        // Exemplo de regra de negócio:
        if (produto.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço deve ser positivo.");
        }
        return produtoRepository.save(produto);
    }

    // 2. Listagem (Read All)
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // 3. Consulta (Read One)
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // 4. Alteração (Update)
    public Produto atualizarProduto(Long id, Produto produtoDetalhes) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));

        // Mapeia os dados novos para o objeto existente
        produtoExistente.setNome(produtoDetalhes.getNome());
        produtoExistente.setDescricao(produtoDetalhes.getDescricao());
        produtoExistente.setPreco(produtoDetalhes.getPreco());
        produtoExistente.setEstoque(produtoDetalhes.getEstoque());

        return produtoRepository.save(produtoExistente);
    }

    // 5. Exclusão (Delete)
    public void deletarProduto(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com ID: " + id);
        }
        produtoRepository.deleteById(id);
    }
}