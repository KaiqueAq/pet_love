package br.com.pet_love.repository;

import br.com.pet_love.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository  extends JpaRepository<FuncionarioEntity, Long> {

    Optional<FuncionarioEntity> findBynome(String nome);
}
