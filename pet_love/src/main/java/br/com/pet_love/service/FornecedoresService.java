package br.com.pet_love.service;

import br.com.pet_love.entity.FornecedoresEntity;
import br.com.pet_love.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class FornecedoresService {

    @Autowired
    private FornecedoresRepository repository;

    public List<FornecedoresEntity> listarTodosFornecedores(){
        return repository.findAll();

    }

    public FornecedoresEntity salvarFornecedores (FornecedoresEntity fornecedores) {
        if (repository.findByCnpj(fornecedores.getCnpj()).isPresent()) {
            throw new IllegalArgumentException("Fornecedor já cadastrado");
        }

        return repository.save(fornecedores);
    }
        public FornecedoresEntity atualizarFornecedor ( Long id ,FornecedoresEntity fornecedores ){
            if (!repository.existsById(id))
                throw new IllegalArgumentException("Fornecedor não encontrado");

            fornecedores.setId(id);
            return repository.save(fornecedores);
        }

        public void excluirFornecedor (Long id) {
            if (!repository.existsById(id)) {
                throw new IllegalArgumentException("Fornecedor não encontrado");
            }

            repository.deleteById(id);
    }


}
