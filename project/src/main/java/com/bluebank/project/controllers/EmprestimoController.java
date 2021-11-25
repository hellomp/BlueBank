package com.bluebank.project.controllers;

import java.util.List;

import com.bluebank.project.dtos.EmprestimoDTO;
import com.bluebank.project.dtos.TransferenciaDTO;
import com.bluebank.project.models.Emprestimo;
import com.bluebank.project.services.EmprestimoService;

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
@RequestMapping("/emprestimo")
public class EmprestimoController {
  
  @Autowired
  EmprestimoService emprestimoService;

  //criar emprestimo
  @PostMapping("/{cpfcnpj}")
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public EmprestimoDTO cadastrarEmprestimo(@PathVariable("cpfcnpj") String cpfcnpj, @Validated @RequestBody Emprestimo emprestimo){
    return emprestimoService.criarEmprestimo(cpfcnpj, emprestimo);
  }

  //consultar emprestimo pelo id
  @GetMapping("/id/{emprestimoId}")
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public EmprestimoDTO consultarEmprestimo(@PathVariable("emprestimoId") Long emprestimoId){
    return emprestimoService.consultarEmprestimoId(emprestimoId);
  }

  //consultar emprestimo pelo cpfcnpj
  @GetMapping("/cpfcnpj/{cpfcnpj}")
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<EmprestimoDTO> consultarEmprestimo(@PathVariable("cpfcnpj") String cpfcnpj){
    return emprestimoService.consultarEmprestimoCpfcnpj(cpfcnpj);
  }

  //pagar emprestimo
  @PostMapping("/pagamento/{emprestimoId}/{contaId}")
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public TransferenciaDTO pagarEmprestimo(@PathVariable("emprestimoId") Long emprestimoId, @PathVariable("contaId") Long contaId){
    return emprestimoService.pagarEmprestimo(emprestimoId, contaId);
  }
}
