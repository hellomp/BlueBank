package com.bluebank.project.repositories;

import java.util.List;

import com.bluebank.project.models.Emprestimo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

  //FIXME: Completar query
  public List<Emprestimo> findByClienteId_Cpfcnpj(String cpfcnpj);
}
