package com.erfer.model;

import lombok.Builder;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@Entity
@Builder
@Table(name = "TB_FINANCIAL_ACCOUNT")
public class FinancialAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "VALUE", nullable = false)
	private Long value;  // Valor em centavos

	@ManyToOne
	@JoinColumn(name = "BANK_ID", referencedColumnName = "ID")
	private Bank bankId;

}
