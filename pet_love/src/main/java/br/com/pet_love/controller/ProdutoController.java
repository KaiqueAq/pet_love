package br.com.pet_love.controller;

import br.com.pet_love.entity.ClienteEntity;
import br.com.pet_love.entity.ProdutoEntity;
import br.com.pet_love.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    //    get
    @GetMapping
    public List<ProdutoEntity> listTodos() {
        return service.listarTodosProdutos();
    }

    //    post
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody ProdutoEntity produto) {
        service.salvarProdutos(produto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Produto salvo com sucesso"));
    }
    //    put
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id, @RequestBody ProdutoEntity produto) {
        service.atualizaProdutos(id, produto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente atualizado com sucesso!"));
    }
    //    delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id) {
        service.deletarProduto(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente deletado com sucesso!"));
    }
}
