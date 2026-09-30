package br.com.pet_love.service;

import br.com.pet_love.entity.ClienteEntity;
import br.com.pet_love.entity.ProdutoEntity;
import br.com.pet_love.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    //    get
    public List<ProdutoEntity> listarTodosProdutos() {
        return repository.findAll();
    }

    //    post
    public ProdutoEntity salvarProdutos(ProdutoEntity produto) {
        if (repository.findByEstoque(produto.getEstoque()).isPresent())
            throw new IllegalArgumentException("Produto já cadastrado!");

        return repository.save(produto);
    }

    //    put
    public ProdutoEntity atualizaProdutos(Long id, ProdutoEntity produto) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Produto não encotrado!");

        produto.setId(id);
        return repository.save(produto);
    }

    //    deleter
    public void deletarProduto(Long id) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Produto não encotrado!");

        repository.deleteById(id);
    }
}
