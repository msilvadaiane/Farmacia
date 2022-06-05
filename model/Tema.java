package com.generation.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@Entity
@Table(name= "tb_tema")
public class Tema {
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message= "O atributo descricao é obrigatório")
	private String descricao;
	
	@OneToMany (mappedBy= "Tema", cascade= CascadeType.REMOVE )
	@JsonIncludeProperties ("Tema")
	private List<Categorias> Categorias;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Categorias> getPostagem() {
		return Categorias;
	}
	public void setPostagem(List<Categorias> postagem) {
		this.Categorias = postagem;
	}
	
	
	
	

}
