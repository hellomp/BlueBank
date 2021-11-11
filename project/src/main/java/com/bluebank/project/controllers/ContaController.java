package com.bluebank.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/conta")
public class ContaController {
	
	
	@Autowired
	private ContaService produtoService;
	
	@GetMapping("/todos")
	public ResponseEntity<List <Conta>> mostrarTodos(){
		return ResponseEntity.ok().body(contaService.mostrarProdutos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> buscarProduto(@PathVariable Long id){
		return ResponseEntity.ok().body(contaService.findById(id));
	}
	
	@PostMapping()
	public ResponseEntity<Conta> create(@RequestBody Conta produto){
		Conta produto2 = contaService.create(produto); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(produto2.getId()).toUri(); 
		return ResponseEntity.created(uri).build(); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody Conta conta){
		return ResponseEntity.ok().body(contaService.update(id, conta));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Conta> delete(@PathVariable Long id){
		return ResponseEntity.ok().body(contaService.delete(id));
	}

}
