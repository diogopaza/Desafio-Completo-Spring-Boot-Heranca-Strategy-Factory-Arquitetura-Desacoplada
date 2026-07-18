-- =========================
-- LIMPEZA (executar sempre antes de popular)
-- Ordem importa: filhas antes da pai (FK constraints)
-- =========================
DELETE FROM pix_joined;
DELETE FROM cartao_joined;
DELETE FROM boleto_joined;
DELETE FROM pagamento_joined;
DELETE FROM pagamento_single_table;

-- =========================
-- SINGLE_TABLE — PIX (10 registros)
-- Colunas numero_cartao e numero_boleto ficam NULL
-- demonstrando o trade-off da estratégia SINGLE_TABLE
-- =========================
INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (100.50, '2026-01-01', 'Pix', 'joao@email.com', NULL, NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (250.00, '2026-01-02', 'Pix', 'maria@email.com', NULL, NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (89.99, '2026-01-03', 'Pix', '11999990001', NULL, NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (500.00, '2026-01-04', 'Pix', '22999990002', NULL, NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (37.50, '2026-01-05', 'Pix', 'pix-chave-aleatoria-001', NULL, NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (1200.00, '2026-01-06', 'Pix', '00011122233', NULL, NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (75.40, '2026-01-07', 'Pix', 'pedro@pix.com', NULL, NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (333.33, '2026-01-08', 'Pix', 'ana@pix.com', NULL, NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (19.90, '2026-01-09', 'Pix', 'pix-chave-aleatoria-002', NULL, NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (900.00, '2026-01-10', 'Pix', 'lucas@email.com', NULL, NULL);

-- =========================
-- SINGLE_TABLE — CARTÃO (10 registros)
-- Colunas chave_pix e numero_boleto ficam NULL
-- =========================
INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (120.50, '2026-02-01', 'Cartao', NULL, '1111-2222-3333-0001', NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (220.00, '2026-02-02', 'Cartao', NULL, '1111-2222-3333-0002', NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (330.70, '2026-02-03', 'Cartao', NULL, '1111-2222-3333-0003', NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (410.90, '2026-02-04', 'Cartao', NULL, '1111-2222-3333-0004', NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (510.10, '2026-02-05', 'Cartao', NULL, '1111-2222-3333-0005', NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (80.00, '2026-02-06', 'Cartao', NULL, '1111-2222-3333-0006', NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (65.45, '2026-02-07', 'Cartao', NULL, '1111-2222-3333-0007', NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (999.99, '2026-02-08', 'Cartao', NULL, '1111-2222-3333-0008', NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (12.34, '2026-02-09', 'Cartao', NULL, '1111-2222-3333-0009', NULL);

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (700.00, '2026-02-10', 'Cartao', NULL, '1111-2222-3333-0010', NULL);

-- =========================
-- SINGLE_TABLE — BOLETO (10 registros)
-- Colunas chave_pix e numero_cartao ficam NULL
-- =========================
INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (50.00, '2026-03-01', 'Boleto', NULL, NULL, 'BOLETO-0001');

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (75.90, '2026-03-02', 'Boleto', NULL, NULL, 'BOLETO-0002');

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (99.99, '2026-03-03', 'Boleto', NULL, NULL, 'BOLETO-0003');

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (110.10, '2026-03-04', 'Boleto', NULL, NULL, 'BOLETO-0004');

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (250.00, '2026-03-05', 'Boleto', NULL, NULL, 'BOLETO-0005');

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (300.00, '2026-03-06', 'Boleto', NULL, NULL, 'BOLETO-0006');

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (410.45, '2026-03-07', 'Boleto', NULL, NULL, 'BOLETO-0007');

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (89.50, '2026-03-08', 'Boleto', NULL, NULL, 'BOLETO-0008');

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (49.99, '2026-03-09', 'Boleto', NULL, NULL, 'BOLETO-0009');

INSERT INTO pagamento_single_table (valor, data, type, chave_pix, numero_cartao, numero_boleto)
VALUES (1000.00, '2026-03-10', 'Boleto', NULL, NULL, 'BOLETO-0010');

-- =========================
-- JOINED — PIX (10 registros)
-- Tabela pai: pagamento_joined | Tabela filha: pix_joined
-- =========================
INSERT INTO pagamento_joined (valor, data) VALUES (100.50, '2026-01-01');
INSERT INTO pix_joined (pagamento_id, chave_pix) VALUES (1, 'pix1@email.com');

INSERT INTO pagamento_joined (valor, data) VALUES (150.75, '2026-01-02');
INSERT INTO pix_joined (pagamento_id, chave_pix) VALUES (2, 'pix2@email.com');

INSERT INTO pagamento_joined (valor, data) VALUES (200.00, '2026-01-03');
INSERT INTO pix_joined (pagamento_id, chave_pix) VALUES (3, 'pix3@email.com');

INSERT INTO pagamento_joined (valor, data) VALUES (89.99, '2026-01-04');
INSERT INTO pix_joined (pagamento_id, chave_pix) VALUES (4, 'pix4@email.com');

INSERT INTO pagamento_joined (valor, data) VALUES (45.20, '2026-01-05');
INSERT INTO pix_joined (pagamento_id, chave_pix) VALUES (5, 'pix5@email.com');

INSERT INTO pagamento_joined (valor, data) VALUES (900.00, '2026-01-06');
INSERT INTO pix_joined (pagamento_id, chave_pix) VALUES (6, 'pix6@email.com');

INSERT INTO pagamento_joined (valor, data) VALUES (333.33, '2026-01-07');
INSERT INTO pix_joined (pagamento_id, chave_pix) VALUES (7, 'pix7@email.com');

INSERT INTO pagamento_joined (valor, data) VALUES (10.00, '2026-01-08');
INSERT INTO pix_joined (pagamento_id, chave_pix) VALUES (8, 'pix8@email.com');

INSERT INTO pagamento_joined (valor, data) VALUES (75.40, '2026-01-09');
INSERT INTO pix_joined (pagamento_id, chave_pix) VALUES (9, 'pix9@email.com');

INSERT INTO pagamento_joined (valor, data) VALUES (500.99, '2026-01-10');
INSERT INTO pix_joined (pagamento_id, chave_pix) VALUES (10, 'pix10@email.com');

-- =========================
-- JOINED — CARTÃO (10 registros)
-- =========================
INSERT INTO pagamento_joined (valor, data) VALUES (120.50, '2026-02-01');
INSERT INTO cartao_joined (pagamento_id, numero_cartao) VALUES (11, '1111-2222-3333-0001');

INSERT INTO pagamento_joined (valor, data) VALUES (220.00, '2026-02-02');
INSERT INTO cartao_joined (pagamento_id, numero_cartao) VALUES (12, '1111-2222-3333-0002');

INSERT INTO pagamento_joined (valor, data) VALUES (330.70, '2026-02-03');
INSERT INTO cartao_joined (pagamento_id, numero_cartao) VALUES (13, '1111-2222-3333-0003');

INSERT INTO pagamento_joined (valor, data) VALUES (410.90, '2026-02-04');
INSERT INTO cartao_joined (pagamento_id, numero_cartao) VALUES (14, '1111-2222-3333-0004');

INSERT INTO pagamento_joined (valor, data) VALUES (510.10, '2026-02-05');
INSERT INTO cartao_joined (pagamento_id, numero_cartao) VALUES (15, '1111-2222-3333-0005');

INSERT INTO pagamento_joined (valor, data) VALUES (80.00, '2026-02-06');
INSERT INTO cartao_joined (pagamento_id, numero_cartao) VALUES (16, '1111-2222-3333-0006');

INSERT INTO pagamento_joined (valor, data) VALUES (65.45, '2026-02-07');
INSERT INTO cartao_joined (pagamento_id, numero_cartao) VALUES (17, '1111-2222-3333-0007');

INSERT INTO pagamento_joined (valor, data) VALUES (999.99, '2026-02-08');
INSERT INTO cartao_joined (pagamento_id, numero_cartao) VALUES (18, '1111-2222-3333-0008');

INSERT INTO pagamento_joined (valor, data) VALUES (12.34, '2026-02-09');
INSERT INTO cartao_joined (pagamento_id, numero_cartao) VALUES (19, '1111-2222-3333-0009');

INSERT INTO pagamento_joined (valor, data) VALUES (700.00, '2026-02-10');
INSERT INTO cartao_joined (pagamento_id, numero_cartao) VALUES (20, '1111-2222-3333-0010');

-- =========================
-- JOINED — BOLETO (10 registros)
-- =========================
INSERT INTO pagamento_joined (valor, data) VALUES (50.00, '2026-03-01');
INSERT INTO boleto_joined (pagamento_id, numero_boleto) VALUES (21, 'BOLETO-0001');

INSERT INTO pagamento_joined (valor, data) VALUES (75.90, '2026-03-02');
INSERT INTO boleto_joined (pagamento_id, numero_boleto) VALUES (22, 'BOLETO-0002');

INSERT INTO pagamento_joined (valor, data) VALUES (99.99, '2026-03-03');
INSERT INTO boleto_joined (pagamento_id, numero_boleto) VALUES (23, 'BOLETO-0003');

INSERT INTO pagamento_joined (valor, data) VALUES (110.10, '2026-03-04');
INSERT INTO boleto_joined (pagamento_id, numero_boleto) VALUES (24, 'BOLETO-0004');

INSERT INTO pagamento_joined (valor, data) VALUES (250.00, '2026-03-05');
INSERT INTO boleto_joined (pagamento_id, numero_boleto) VALUES (25, 'BOLETO-0005');

INSERT INTO pagamento_joined (valor, data) VALUES (300.00, '2026-03-06');
INSERT INTO boleto_joined (pagamento_id, numero_boleto) VALUES (26, 'BOLETO-0006');

INSERT INTO pagamento_joined (valor, data) VALUES (410.45, '2026-03-07');
INSERT INTO boleto_joined (pagamento_id, numero_boleto) VALUES (27, 'BOLETO-0007');

INSERT INTO pagamento_joined (valor, data) VALUES (89.50, '2026-03-08');
INSERT INTO boleto_joined (pagamento_id, numero_boleto) VALUES (28, 'BOLETO-0008');

INSERT INTO pagamento_joined (valor, data) VALUES (49.99, '2026-03-09');
INSERT INTO boleto_joined (pagamento_id, numero_boleto) VALUES (29, 'BOLETO-0009');

INSERT INTO pagamento_joined (valor, data) VALUES (1000.00, '2026-03-10');
INSERT INTO boleto_joined (pagamento_id, numero_boleto) VALUES (30, 'BOLETO-0010');
