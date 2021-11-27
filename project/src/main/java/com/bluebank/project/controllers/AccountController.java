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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bluebank.project.dtos.AccountDTO;
import com.bluebank.project.models.Account;
import com.bluebank.project.services.ContaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/conta")
@Api(value="API BlueBank")
@CrossOrigin(origins="*")
public class AccountController {
	
	@Autowired
	ContaService contaService;
	
	@PostMapping("/{cpfcnpj}")
	@ApiOperation(value="Cadastra um conta com o CPF ou CNPJ")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountDTO registerAccount(@PathVariable("cpfcnpj") String cpfcnpj, @Validated @RequestBody Account conta){
		return contaService.cadastrarNovaConta(cpfcnpj, conta);
	}

	@GetMapping("/id/{id}")
	@ApiOperation(value="Consulta os dados da conta atraves do id")
	@ResponseStatus(HttpStatus.OK)
	public AccountDTO consultAccountRegistryById(@PathVariable("id") Long id){
		return contaService.consultarCadastroContaId(id);
	}
	
	@GetMapping("/cpfcnpj/{cpfcnpj}")
	@ApiOperation(value="Consulta os dados da conta atraves do CPF ou CNPJ")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountDTO> consultAccountRegistryByCpfcnpj(@PathVariable("cpfcnpj") String cpfcnpj){
		return contaService.consultarCadastrosContaCpfcnpj(cpfcnpj);
	}
	
	@PutMapping("/update/{id}/{cpfcnpj}")
	@ApiOperation(value="Atualiza os dados pelo id ou CPF ou CNPJ")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public AccountDTO changeAccountHolder(@PathVariable("id") Long id, @PathVariable("cpfcnpj") String cpfcnpj){
		return contaService.AlterarTitularContaId(id, cpfcnpj);
	}
	
	@DeleteMapping("/delete/id/{id}")
	@ApiOperation(value="Desativa a conta do cliente pelo id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deactivateAccountRegistryById(@PathVariable("id") Long id){
		contaService.desativarContaId(id);
	}
	
	@DeleteMapping("/delete/cpfcnpj/{cpfcnpj}")
	@ApiOperation(value="Desativa a conta do cliente pelo CPF ou CNPJ")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deactivateAccountRegistryByCpfcnpj(@PathVariable("cpfcnpj") String cpfcnpj){
		contaService.desativarContasCpfcnpj(cpfcnpj);
	}

}
