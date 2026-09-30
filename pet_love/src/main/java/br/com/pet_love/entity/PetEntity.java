package br.com.pet_love.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table  (name = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PetEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String especie;

    @Column(nullable = false)
    private String raca;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;
}
