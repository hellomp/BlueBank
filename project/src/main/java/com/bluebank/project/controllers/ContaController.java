package com.bluebank.project.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bluebank.project.models.Cliente;
import com.bluebank.project.models.Conta;

@RestController
@RequestMapping(path = "/conta")
public class ContaController {
	
	
	@Autowired
	private ContaService produtoService;
	
	
	//criar conta
	@PostMapping()
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	ResponseEntity<Conta> cadastrarConta(@Validated @RequestBody Conta conta, BindingResult br){
		return ResponseEntity.body(ClasseDeServicedeConta.cadastrarNovaConta(conta));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Conta> cadastrarConta(@Validated @RequestBody Conta cliente, BindingResult br){
		Conta conta = contaService.create(conta); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(conta.getId()).toUri();
		return ResponseEntity.created(uri).build(); 
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody Conta conta){
		return ResponseEntity().body(contaService.update(id, conta));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Conta> delete(@PathVariable Long id){
		return ResponseEntity().body(contaService.delete(id));
	}

}
