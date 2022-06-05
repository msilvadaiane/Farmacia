package com.generation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.model.Categorias;
import com.generation.repository.CategoriasRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
	
	@Autowired
	private CategoriasRepository CategoriasRepository;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> getAll(){
		return ResponseEntity.ok(CategoriasRepository.findAll());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Categorias> getById(@PathVariable Long id){
		return CategoriasRepository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());	
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity <List<Categorias>> getByCategoria(@PathVariable String nome){
		return ResponseEntity.ok(CategoriasRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Categorias> postCategoria(@Valid @RequestBody Categorias categorias){
		return ResponseEntity.status(HttpStatus.CREATED).body(CategoriasRepository.save(categorias));	
	}
	
	@PutMapping
	public ResponseEntity<Categorias> putCategoria(@Valid @RequestBody Categorias categorias) {
					
		return CategoriasRepository.findById(categorias.getId())
				.map(resposta -> ResponseEntity.ok().body(CategoriasRepository.save(categorias)))
				.orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable Long id) {
		
		return CategoriasRepository.findById(id)
				.map(resposta -> {
					CategoriasRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
	

}
