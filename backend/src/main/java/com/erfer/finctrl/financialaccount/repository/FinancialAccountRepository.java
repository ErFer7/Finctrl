package com.erfer.finctrl.financialaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erfer.model.FinancialAccount;

@Repository
public interface FinancialAccountRepository extends JpaRepository<FinancialAccount, Long> {
}
