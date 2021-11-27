package com.bluebank.project.repositories;

import java.util.List;

import com.bluebank.project.models.Loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

  public List<Loan> findByClientId_Cpfcnpj(String cpfcnpj);
}
