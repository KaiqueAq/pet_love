package br.com.pet_love.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_fornecedores")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FornecedoresEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long id;
    @Column(nullable = false)
    private String razaoSocial;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String emal;

    @Column(nullable = false)
    private String telefone;
}
