package com.erfer.model;

import java.sql.Date;

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
@Table(name = "TB_REGISTER")
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "DATE", nullable = false)
	private Date date;

	@Column(name = "NAME", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "FINANCIAL_ACCOUNT_ID", referencedColumnName = "ID", nullable = false)
	private FinancialAccount financialAccountId;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", nullable = false)
	private Category categoryId;

	@Column(name = "VALUE", nullable = false)
	private Long value;  // Valor em centavos
}
