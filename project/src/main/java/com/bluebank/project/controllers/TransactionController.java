package com.bluebank.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bluebank.project.dtos.DepositDTO;
import com.bluebank.project.dtos.WithdrawDTO;
import com.bluebank.project.models.Transaction;
import com.bluebank.project.services.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
  
  @Autowired
  TransacaoService transacaoService;

  @PostMapping("/saque/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public WithdrawDTO withdraw(@PathVariable("id") Long id, @RequestBody Transaction transacao) {
		return transacaoService.criarSaque(id, transacao);
	}
	
	@PostMapping("/deposito/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public DepositDTO deposit(@PathVariable("id") Long id, @RequestBody Transaction transacao) {
		return transacaoService.criarDeposito(id, transacao);
	}
	
	@GetMapping("/saldo/{id}")
	@ResponseStatus(HttpStatus.OK)
	public double balance(@PathVariable("id") Long id){
		return transacaoService.findSaldo(id);
	}
	
	@GetMapping("/extrato/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Object> extract(@PathVariable("id") Long id){
		return transacaoService.findByContaId(id);
	}

}