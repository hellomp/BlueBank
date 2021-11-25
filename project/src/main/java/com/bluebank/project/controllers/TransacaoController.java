package com.bluebank.project.controllers;

import java.util.List;

import com.bluebank.project.dtos.DepositoDTO;
import com.bluebank.project.dtos.SaqueDTO;
import com.bluebank.project.models.Transacao;
import com.bluebank.project.services.TransacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
  
  @Autowired
  TransacaoService transacaoService;

  @PostMapping("/saque/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public SaqueDTO saque(@PathVariable("id") Long id, @RequestBody Transacao transacao) {
		return transacaoService.criarSaque(id, transacao);
	}
	
	@PostMapping("/deposito/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public DepositoDTO deposito(@PathVariable("id") Long id, @RequestBody Transacao transacao) {
		return transacaoService.criarDeposito(id, transacao);
	}
	
	@GetMapping("/saldo/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public double saldo(@PathVariable("id") Long id){
		return transacaoService.findSaldo(id);
	}
	
	@GetMapping("/extrato/{id}")
//	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Object> extrato(@PathVariable("id") Long id){
		return transacaoService.findByContaId(id);
	}

}