package br.com.pet_love.service;


import br.com.pet_love.entity.ClienteEntity;
import br.com.pet_love.entity.FuncionarioEntity;
import br.com.pet_love.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FuncionarioService {
    @Autowired
     private FuncionarioRepository repository;

    public List<FuncionarioEntity> listarTodosFuncionario (){
        return repository.findAll();
    }

    public FuncionarioEntity salvarFuncionario(FuncionarioEntity funcionario) {
        if (repository.findBynome(funcionario.getNome()).isPresent())
            throw new IllegalArgumentException("Funcionario já existe!");

        return repository.save(funcionario);
    }

    public FuncionarioEntity atualizarFuncionario(Long id, FuncionarioEntity funcionario) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Funcionario não encotrado!");

        funcionario.setId(id);
        return repository.save(funcionario);
    }

    public void deletarFuncionario(Long id) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Funcionario não encotrado!");

        repository.deleteById(id);
    }


}


