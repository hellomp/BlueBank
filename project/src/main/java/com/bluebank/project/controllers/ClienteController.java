package com.bluebank.project.controllers;

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

import com.bluebank.project.dtos.ClientDTO;
import com.bluebank.project.mappers.ClientMapper;
import com.bluebank.project.models.Cliente;
import com.bluebank.project.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ClientMapper clientMapper;
//	public ClienteController() {
//		
//	}	
	
	//criar cliente
	// obs retornar DTO sem senha
//	@PostMapping()
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<Cliente> cadastrarCliente(@Validated @RequestBody Cliente cliente, BindingResult br) {//throws DataIntegrityViolationException, Exception {
////		if(br.hasErrors()) throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
//		return ResponseEntity.body(clienteService.cadastrarNovoCliente(cliente));
//	}
	
	@PostMapping()
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastrarCliente(@Validated @RequestBody Cliente cliente, BindingResult br) {//throws DataIntegrityViolationException, Exception {
//		if(br.hasErrors()) throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		return clienteService.cadastrarNovoCliente(cliente);
	}
	
	//consultar cliente
//	@GetMapping("/{cpfcnpj")
//	@ResponseStatus(HttpStatus.OK)
//	public ResponseEntity<Cliente> consultarCadastro(@PathVariable("cpfcnpj") String cpfcnpj) {
//		return ResponseEntity.body(clienteService.consultarCadastroCliente(cpfcnpj)).build();
//	}
	
	@GetMapping("/{cpfcnpj")
	@ResponseStatus(HttpStatus.OK)
	public Cliente consultarCadastro(@PathVariable("cpfcnpj") String cpfcnpj) {
		return clienteService.consultarCadastroCliente(cpfcnpj);
	}
	
	//atualizar cliente
//	@PutMapping("/{id}")
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	public ResponseEntity<Cliente> atualizarCadastro(@PathVariable Long id, @RequestBody Cliente cliente) {//, BindingResult br) throws DataIntegrityViolationException, Exception {
////		if(br.hasErrors()) throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
//		Cliente clienteAux = clienteService.atualizarCadastroCliente(id, cliente);
//		return ResponseEntity.body(clienteAux).build;
//	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Cliente atualizarCadastro(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {//, BindingResult br) throws DataIntegrityViolationException, Exception {
//		if(br.hasErrors()) throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
//		Cliente client = clientMapper.toClient(clientDTO);
		return clienteService.atualizarCadastroCliente(clientDTO);
	}
	
	//excluir coliente
//	@DeleteMapping("/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public ResponseEntity<Void> excluirConta(@PathVariable("cpfcnpj") String cpfcnpj) {
//		clienteService.excluirContaCliente(cpfcnpj);
//		return ResponseEntity.body().build();
//	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirConta(@PathVariable("cpfcnpj") String cpfcnpj) {
		clienteService.excluirContaCliente(cpfcnpj);
	}
}
