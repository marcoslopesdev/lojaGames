package com.generation.lojaGames.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O atributo nome é obrigatório")
    @Size(min = 1, max = 100, message = "O atributo nome deve conter no mínimo 1 e no máximo 100 caracteres")
    private String nome;
    
    @NotBlank(message = "O atributo descrição é obrigatório")
    @Size(min = 10, max = 500, message = "O atributo descrição deve conter no mínimo 10 e no máximo 500 caracteres")
    private String descricao;
    
    @NotNull(message = "O atributo preço é obrigatório")
    @DecimalMin(value = "0.01", message = "O preço deve ser no mínimo R$ 0,01")
    @DecimalMax(value = "20000.00", message = "O preço deve ser no máximo R$ 20.000,00")
    private BigDecimal preco;
    
    @UpdateTimestamp
    private LocalDateTime data;
    
    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
    
    
}
