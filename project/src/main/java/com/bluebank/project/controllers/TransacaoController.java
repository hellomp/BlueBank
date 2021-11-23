package com.bluebank.project.controllers;

import java.util.List;

import com.bluebank.project.dtos.EmprestimoDTO;
import com.bluebank.project.models.Emprestimo;
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

  //criar emprestimo
  @PostMapping("/emprestimo/{cpfcnpj}")
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public EmprestimoDTO cadastrarEmprestimo(@PathVariable("cpfpcnpj") String cpfcnpj, @Validated @RequestBody Emprestimo emprestimo){
    return transacaoService.criarEmprestimo(cpfcnpj, emprestimo);
  }

  //consultar emprestimo pelo id
  @GetMapping("/emprestimo/id/{emprestimoId}")
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public Emprestimo consultarEmprestimo(@PathVariable("emprestimoId") Long emprestimoId){
    return transacaoService.consultarEmprestimoId(emprestimoId);
  }

  //consultar emprestimo pelo cpfcnpj
  @GetMapping("/emprestimo/cpfcnpj/{cpfcnpj}")
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<Emprestimo> consultarEmprestimo(@PathVariable("cpfcnpj") String cpfcnpj){
    return transacaoService.consultarEmprestimoCpfcnpj(cpfcnpj);
  }
}
