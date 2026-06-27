-- =========================
-- 10 REGISTROS PIX
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
-- 10 REGISTROS CARTAO
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
-- 10 REGISTROS BOLETO
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