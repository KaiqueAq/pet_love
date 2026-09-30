package br.com.pet_love.service;

import br.com.pet_love.entity.PetEntity;
import br.com.pet_love.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired

    private PetRepository repository;

    public List<PetEntity> ListarTodosPets() { return repository.findAll();}

    public PetEntity salvarPets(PetEntity pet) {
        if (repository.findByNome(pet.getNome()).isPresent())
            throw new IllegalArgumentException("Pet já cadastrado!");

        return repository.save(pet);
    }

    public PetEntity atualizarPets(Long id, PetEntity pet) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Pet não encontrado!");

        pet.setId(id);
        return repository.save(pet);
    }

    public void deletarPet(Long id) {
            if (!repository.existsById(id))
                throw  new IllegalArgumentException("Pet não encontrado");
        }
}
