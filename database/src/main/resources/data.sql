INSERT INTO tb_bank (id, name) VALUES (1, 'Banco do Brasil');
INSERT INTO tb_bank (id, name) VALUES (2, 'Inter');

INSERT INTO tb_financial_account (id, name, value, bank_id) VALUES (1, 'Conta corrente', 10000, 1);
INSERT INTO tb_financial_account (id, name, value, bank_id) VALUES (2, 'Conta corrente', 5000, 2);
INSERT INTO tb_financial_account (id, name, value, bank_id) VALUES (3, 'Conta poupança', 5000, 2);

INSERT INTO tb_category (id, name) VALUES (1, 'Fundo de segurança');
INSERT INTO tb_category (id, name) VALUES (2, 'Mensalidades');
INSERT INTO tb_category (id, name) VALUES (3, 'Compras');
INSERT INTO tb_category (id, name) VALUES (4, 'Livre');
