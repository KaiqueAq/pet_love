package br.com.pet_love.controller;

import br.com.pet_love.entity.PetEntity;
import br.com.pet_love.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService service;

    @GetMapping
    public List<PetEntity> listTodos() { return service.ListarTodosPets();
    }

    @PostMapping

    public ResponseEntity<Map<String, Object>>salvar(@RequestBody PetEntity pet) {
        service.salvarPets(pet);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem","Pets salvo com sucesso!"));
    }


    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id, @RequestBody PetEntity pet) {
        service.atualizarPets(id, pet);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Pet atualizado com sucesso!"));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id) {
        service.deletarPet(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Pet deletado com sucesso!"));
    }
}
