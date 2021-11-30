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
import com.bluebank.project.dtos.TransactionDTO;
import com.bluebank.project.dtos.WithdrawDTO;
import com.bluebank.project.models.Transaction;
import com.bluebank.project.services.TransactionService;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
  
  @Autowired
  TransactionService transacaoService;

  @PostMapping("/saque/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public WithdrawDTO withdraw(@PathVariable("id") Long id, @RequestBody Transaction transacao) {
		return transacaoService.withdrawAmount(id, transacao);
	}
	
	@PostMapping("/deposito/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public DepositDTO deposit(@PathVariable("id") Long id, @RequestBody Transaction transacao) {
		return transacaoService.depositAmount(id, transacao);
	}
	
	@GetMapping("/saldo/{id}")
	@ResponseStatus(HttpStatus.OK)
	public double balance(@PathVariable("id") Long id){
		return transacaoService.showAccountBalanceById(id);
	}
	
	@GetMapping("/extrato/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<TransactionDTO> extract(@PathVariable("id") Long id){
		return transacaoService.showTransactionsByAccountId(id);
	}

}