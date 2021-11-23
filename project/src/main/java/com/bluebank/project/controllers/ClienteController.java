package com.bluebank.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import com.bluebank.project.dtos.ClientDTO;
import com.bluebank.project.models.Cliente;
import com.bluebank.project.services.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cliente")
@Api(value="API BlueBank")
@CrossOrigin(origins="*")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping()
	@ApiOperation(value="Cadastra um novo cliente com od dados pessoais")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public ClientDTO cadastrarCliente(@Validated @RequestBody Cliente cliente, BindingResult br) {//throws DataIntegrityViolationException, Exception {
//		if(br.hasErrors()) throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		return clienteService.cadastrarNovoCliente(cliente);
	}
	
	@GetMapping("/{cpfcnpj}")
	@ApiOperation(value="Consulta os dados de um cliente atraves do CPF ou CNPJ")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ClientDTO consultarCadastro(@PathVariable("cpfcnpj") String cpfcnpj) {
		return clienteService.consultarCadastroCliente(cpfcnpj);
	}
	
	@GetMapping("/nome/{nome}")
	@ApiOperation(value="Consulta os dados de um cliente atraves do nome")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ClientDTO> consultarCadastroPorNome(@PathVariable("nome") String nome) {
		return clienteService.buscarClientePorNome(nome);
	}
	
	@PutMapping("/{cpfcnpj}")
	@ApiOperation(value="Atualiza o cadastro do clieNte atraves do CPF ou CNPJ")
	@ResponseBody
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ClientDTO atualizarCadastro(@PathVariable("cpfcnpj") String cpfcnpj, @RequestBody ClientDTO clientDTO) {//, BindingResult br) throws DataIntegrityViolationException, Exception {
//		if(br.hasErrors()) throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		return clienteService.atualizarCadastroCliente(cpfcnpj, clientDTO);
	}
	
	@DeleteMapping("/{cpfcnpj}")
	@ApiOperation(value="Desativa o cadastro do cliente")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirConta(@PathVariable("cpfcnpj") String cpfcnpj) {
		clienteService.desativarContaCliente(cpfcnpj);
	}
}
