package com.suauniversidade.lojacrud.repository;

import com.suauniversidade.lojacrud.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// O JpaRepository já oferece os métodos CRUD: save(), findById(), findAll(), deleteById()
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Nenhuma implementação de método é necessária aqui para o CRUD básico
}