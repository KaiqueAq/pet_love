package br.com.pet_love.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tab_funcionario")
public class FuncionarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String dataDeEmissao;
}
