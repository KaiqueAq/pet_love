package br.com.pet_love.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoEntity {
    //    id · nome · descricao · preco · estoque
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    private int estoque;
}
