package com.bluebank.project.mappers;

import com.bluebank.project.dtos.EmprestimoDTO;
import com.bluebank.project.models.Emprestimo;

import org.springframework.stereotype.Service;

@Service
public class EmprestimoMapper {

	public EmprestimoDTO updateEmprestimoDtoFromEmprestimo(Emprestimo emprestimo, EmprestimoDTO emprestimoDTO) {
		emprestimoDTO.setCliente(emprestimo.getCliente());
		emprestimoDTO.setNumeroContrato(emprestimo.getNumeroContrato());
		emprestimoDTO.setDataInicio(emprestimo.getDataInicio().toString());
		emprestimoDTO.setDataFim(emprestimo.getDataFim().toString());
		emprestimoDTO.setValorEmprestimo(emprestimo.getValorEmprestimo());
		emprestimoDTO.setPercentualJuros(emprestimo.getPercentualJuros());
		emprestimoDTO.setQuantParcelas(emprestimo.getQuantParcelas());
		return emprestimoDTO;
	}
}
