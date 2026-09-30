package br.com.pet_love.controller;

import br.com.pet_love.entity.FornecedoresEntity;
import br.com.pet_love.entity.FuncionarioEntity;
import br.com.pet_love.service.FornecedoresService;
import br.com.pet_love.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioEntity> listarTodos() {
        return service.listarTodosFuncionario();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody FuncionarioEntity funcionario) {
        service.salvarFuncionario(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Funcionario cadastrado com sucesso!"));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,String>> atualizar (@PathVariable Long id, @RequestBody FuncionarioEntity funcionario) {
        service.atualizarFuncionario(id,funcionario);{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(Map.of("Mensagem", "Funcionario atualizado com sucesso"));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar (@PathVariable Long id) {
        service.deletarFuncionario(id);
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(Map.of("Mensagem", "Funcionario excluido com sucesso"));
        }
    }
}
