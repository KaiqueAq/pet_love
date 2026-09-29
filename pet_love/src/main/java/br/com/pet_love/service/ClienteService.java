package br.com.pet_love.service;

import br.com.pet_love.entity.ClienteEntity;
import br.com.pet_love.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;


    //    get
    public List<ClienteEntity> listTodosClientes() {
        return repository.findAll();
    }

//    post
    public ClienteEntity salvarClientes(ClienteEntity clinte) {
        if (repository.findByEmail(clinte.getEmail()).isPresent())
            throw new IllegalArgumentException("Cliente já existe!");

        return repository.save(clinte);
    }

    //    put
    public ClienteEntity atualizarClientes(Long id, ClienteEntity clinte) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Cliente não encotrado!");

        clinte.setId(id);
        return repository.save(clinte);
    }
//    delete
    public void deletarClientes(Long id) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Cliente não encotrado!");

         repository.deleteById(id);
    }

}
