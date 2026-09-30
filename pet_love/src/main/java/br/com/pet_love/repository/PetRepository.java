package br.com.pet_love.repository;

import br.com.pet_love.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {
    Optional<PetEntity>findByNome(String nome);

}
