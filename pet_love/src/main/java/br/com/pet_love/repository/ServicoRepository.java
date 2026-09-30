package br.com.pet_love.repository;

import br.com.pet_love.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoEntity, Long> {
    Optional<ServicoEntity> findByNome(String nome);
}