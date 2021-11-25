package com.bluebank.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/conta")
@Api(value="API BlueBank")
@CrossOrigin(origins="*")
public class ContaController {
	
	@Autowired
	ContaService contaService;
	
	//criar conta
	@PostMapping("/{cpfcnpj}")
	@ApiOperation(value="Cadastra um conta com o CPF ou CNPJ")
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
	@ApiOperation(value="Consulta os dados da conta atraves do id")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public AccountDTO consultarConta(@PathVariable("id") Long id){
		return contaService.consultarCadastroContaId(id);
	}
	
	@GetMapping("/cpfcnpj/{cpfcnpj}")
	@ApiOperation(value="Consulta os dados da conta atraves do CPF ou CNPJ")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<AccountDTO> consultarConta(@PathVariable("cpfcnpj") String cpfcnpj){
		return contaService.consultarCadastrosContaCpfcnpj(cpfcnpj);
	}
	
	@PutMapping("/update/{id}/{cpfcnpj}")
@ApiOperation(value="Atualiza os dados pelo id ou CPF ou CNPJ")
	@ResponseBody
	@ResponseStatus(HttpStatus.ACCEPTED)
	public AccountDTO update(@PathVariable("id") Long id, @PathVariable("cpfcnpj") String cpfcnpj){
		return contaService.AlterarTitularContaId(id, cpfcnpj);
	}
	
	@DeleteMapping("/delete/id/{id}")
	@ApiOperation(value="Desativa a conta do cliente pelo id")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id){
		contaService.desativarContaId(id);
	}
	
	@DeleteMapping("/delete/cpfcnpj/{cpfcnpj}")
	@ApiOperation(value="Desativa a conta do cliente pelo CPF ou CNPJ")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("cpfcnpj") String cpfcnpj){
		contaService.desativarContasCpfcnpj(cpfcnpj);
	}

}
