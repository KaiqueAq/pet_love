package br.com.pet_love.controller;


import br.com.pet_love.entity.FornecedoresEntity;
import br.com.pet_love.service.FornecedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedores")
public class FornecedoresController {

    @Autowired
    private FornecedoresService service;

    @GetMapping
    public List<FornecedoresEntity> listarTodos() {
        return service.listarTodosFornecedores();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody FornecedoresEntity fornecedores) {
        service.salvarFornecedores(fornecedores);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Fornecedor cadastrado com sucesso!"));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,String>> atualizar (@PathVariable Long id, @RequestBody FornecedoresEntity fornecedores) {
        service.atualizarFornecedor(id,fornecedores);{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(Map.of("Mensagem", "Fornecedor atualizado com sucesso"));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar (@PathVariable Long id) {
        service.excluirFornecedor(id);
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(Map.of("Mensagem", "Fornecedor excluido com sucesso"));
        }
    }
}



