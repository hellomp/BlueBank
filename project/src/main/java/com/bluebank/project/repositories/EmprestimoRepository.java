package com.bluebank.project.repositories;

import com.bluebank.project.models.Emprestimo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
  
}
