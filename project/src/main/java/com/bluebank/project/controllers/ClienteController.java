package com.bluebank.project.controllers;

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

@RestController
@RequestMapping("/cliente")
public class ClienteController {

//	@Autowired ClasseDeServicedeCliente
//	@Autowired ClasseDeModelDeCliente
//	public ClienteController() {
//		
//	}	
	
	//criar cliente
	// obs retornar DTO sem senha
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	ResponseEntity<Cliente> cadastrarCliente(@Validated @ResponseBody Cliente cliente, BindingResult br)
							throws DataIntegrityViolationException, Exception {
		if(br.hasErrors()) throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		return ResponseEntity.body(ClasseDeServicedeCliente.cadastrarNovoCliente(cliente));
	}
	
	//consultar cliente
	@GetMapping("/{cpfcnpj")
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<Cliente> consultarCadastro(@PathVariable("cpfcnpj") String cpfcnpj) {
		return ResponseEntity.body(ClasseDeServicedeCliente.consultarCadastroCliente(cpfcnpj));
	}
	
	//atualizar cliente
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Cliente cliente, BindingResult br)
								   throws DataIntegrityViolationException, Exception {
		if(br.hasErrors()) throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		Client clientAux = ClasseDeServicedeCliente.update(id, cliente);
		return ResponseEntity.ok().body(newObj);
	}
	
	//excluir coliente
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	ResponseEntity<Void> excluirConta(@PathVariable("cpfcnpj") String cpfcnpj) {
		ClasseDeServicedeCliente.excluirContaCliente(cpfcnpj);
		return ResponseEntity.build();
	}
}
