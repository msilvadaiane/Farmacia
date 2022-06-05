package com.generation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.model.Categorias;

public interface CategoriasRepository  extends JpaRepository<Categorias, Long>{
	
	public List<Categorias> finAllByTituloConainingIgnoreCase(@Param("titulo") String titulo);

	public List<Categorias> findAllByNomeContainingIgnoreCase(String nome);
	
	
	
	
	
	

}
