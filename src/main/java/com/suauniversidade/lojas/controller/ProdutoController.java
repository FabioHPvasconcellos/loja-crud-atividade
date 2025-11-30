package com.suauniversidade.lojacrud.controller;

import com.suauniversidade.lojacrud.model.Produto;
import com.suauniversidade.lojacrud.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos") // Todos os EndPoints começam com /api/produtos
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // CADASTRO (POST - Create)
    // EndPoint: POST /api/produtos
    @PostMapping
    public ResponseEntity<?> cadastrarProduto(@RequestBody Produto produto) {
        try {
            Produto novoProduto = produtoService.salvarProduto(produto);
            return new ResponseEntity<>(novoProduto, HttpStatus.CREATED); // Status 201
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // Status 400
        }
    }

    // LISTAGEM (GET - Read All)
    // EndPoint: GET /api/produtos
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarTodos();
    }

    // CONSULTA (GET - Read One)
    // EndPoint: GET /api/produtos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Produto> consultarProduto(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)        // Se existir, retorna 200 OK
                .orElse(ResponseEntity.notFound().build()); // Se não, retorna 404 Not Found
    }

    // ALTERAÇÃO (PUT - Update)
    // EndPoint: PUT /api/produtos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Produto> alterarProduto(@PathVariable Long id, @RequestBody Produto produtoDetalhes) {
        try {
            Produto produtoAtualizado = produtoService.atualizarProduto(id, produtoDetalhes);
            return ResponseEntity.ok(produtoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Erro se o ID não existir
        }
    }

    // EXCLUSÃO (DELETE - Delete)
    // EndPoint: DELETE /api/produtos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclusaoProduto(@PathVariable Long id) {
        try {
            produtoService.deletarProduto(id);
            return ResponseEntity.noContent().build(); // Status 204
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Erro se o ID não existir
        }
    }
}