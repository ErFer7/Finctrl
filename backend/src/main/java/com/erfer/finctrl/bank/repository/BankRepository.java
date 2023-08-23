package com.erfer.finctrl.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erfer.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
