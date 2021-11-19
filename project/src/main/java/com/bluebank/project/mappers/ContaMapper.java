package com.bluebank.project.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebank.project.dtos.AccountDTO;
import com.bluebank.project.dtos.ClientDTO;
import com.bluebank.project.enums.AccountStatusEnum;
import com.bluebank.project.models.Conta;

@Service
public class ContaMapper {

//	public void updateAccountFromDto(AccountDTO accountDTO, Conta conta) {
//		if (!accountDTO.getCliente().isBlank()) conta.setCliente(accountDTO.getCliente());
//		if (!accountDTO.getAgencia().isEmpty()) conta.setAgencia(accountDTO.getAgencia());
//		if (!accountDTO.getTipoConta().isBlank()) conta.setTipoConta(accountDTO.getTipoConta());
//	}
	
	@Autowired
	ClientMapperImpl clientMapper;
	
	public AccountDTO updateDtoFromAccount(Conta conta, AccountDTO accountDTO) {
//		ClientDTO clientDTOAux = new ClientDTO();
//		clientMapper.updateDtoFromClient(, clientDTOAux);
		
		accountDTO.setId(conta.getId());
		accountDTO.setNomeDoCliente(conta.getCliente().getNome());
		accountDTO.setAgencia(conta.getAgencia());
		accountDTO.setTipoConta(conta.getTipoConta());
		
		if(conta.getStatus().equals(AccountStatusEnum.Inativa)) {
			String status = "Conta inativa desde " + conta.getDateForReference().toString();
			accountDTO.setStatus(status);
			
		} else if(conta.getStatus().equals(AccountStatusEnum.Ativa)) {
			String status = "Conta ativa desde: " + conta.getDateForReference().toString();
			accountDTO.setStatus(status);
			
		}
		accountDTO.setSaldoAtual(conta.getSaldo());
		
		return accountDTO;
	}

}