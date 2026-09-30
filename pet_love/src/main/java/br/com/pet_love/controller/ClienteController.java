package br.com.pet_love.controller;

import br.com.pet_love.entity.ClienteEntity;
import br.com.pet_love.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;


    //    get
    @GetMapping
    public List<ClienteEntity> ListaTodos() {
        return service.listTodosClientes();
    }

    //    post
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody ClienteEntity clinte) {
        service.salvarClientes(clinte);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cliente criado com sucesso!"));
    }
//    put
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id, @RequestBody ClienteEntity clinte) {
        service.atualizarClientes(id, clinte);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente atualizado com sucesso!"));
    }
//    delete
    @DeleteMapping("/{id}")
public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id) {
    service.deletarClientes(id);
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(Map.of("mensagem", "Cliente deletado com sucesso!"));
}
}
