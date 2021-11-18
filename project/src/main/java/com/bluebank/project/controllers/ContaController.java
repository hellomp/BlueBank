package com.bluebank.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.bluebank.project.dtos.AccountDTO;
import com.bluebank.project.models.Conta;
import com.bluebank.project.services.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	ContaService contaService;
	
	//criar conta
	@PostMapping("/{cpfcnpj}")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public AccountDTO cadastrarConta(@PathVariable("cpfcnpj") String cpfcnpj, @Validated @RequestBody Conta conta){
		return contaService.cadastrarNovaConta(cpfcnpj, conta);
	}
	
//	@PostMapping()
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<Conta> cadastrarConta(@Validated @RequestBody Conta cliente, BindingResult br){
//		Conta conta = contaService.create(conta); 
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
//				path("/{id}").buildAndExpand(conta.getId()).toUri();
//		return ResponseEntity.created(uri).build(); 
//	}
	
	@GetMapping("/id/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public AccountDTO consultarConta(@PathVariable("id") Long id){
		return contaService.consultarCadastroContaId(id);
	}
	
	@GetMapping("/cpfcnpj/{cpfcnpj}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<AccountDTO> consultarConta(@PathVariable("cpfcnpj") String cpfcnpj){
		return contaService.consultarCadastrosContaCpfcnpj(cpfcnpj);
	}
	
	@PutMapping("/update/{id}/{cpfcnpj}")
	@ResponseBody
	@ResponseStatus(HttpStatus.ACCEPTED)
	public AccountDTO update(@PathVariable("id") Long id, @PathVariable("cpfcnpj") String cpfcnpj){
		return contaService.AlterarTitularContaId(id, cpfcnpj);
	}
	
	@DeleteMapping("/delete/id/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id){
		contaService.desativarContaId(id);
	}
	
	@DeleteMapping("/delete/cpfcnpj/{cpfcnpj}")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("cpfcnpj") String cpfcnpj){
		contaService.desativarContasCpfcnpj(cpfcnpj);
	}

}
