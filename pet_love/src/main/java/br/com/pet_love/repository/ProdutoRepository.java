package br.com.pet_love.repository;

import br.com.pet_love.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    Optional<ProdutoEntity> findByEstoque(int estoque);
}
