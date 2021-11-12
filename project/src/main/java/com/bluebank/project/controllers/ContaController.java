package com.bluebank.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bluebank.project.dtos.AccountDTO;
import com.bluebank.project.models.Conta;
import com.bluebank.project.services.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	ContaService contaService;
	
	//criar conta
	@PostMapping()
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Conta cadastrarConta(@Validated @RequestBody Conta conta, BindingResult br){
		return contaService.cadastrarNovaConta(conta);
	}
	
//	@PostMapping()
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<Conta> cadastrarConta(@Validated @RequestBody Conta cliente, BindingResult br){
//		Conta conta = contaService.create(conta); 
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
//				path("/{id}").buildAndExpand(conta.getId()).toUri();
//		return ResponseEntity.created(uri).build(); 
//	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Conta update(@PathVariable Long id, @RequestBody AccountDTO accountDTO){
		return contaService.atualizarCadastroConta(id, accountDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		contaService.excluirConta(id);
	}

}
