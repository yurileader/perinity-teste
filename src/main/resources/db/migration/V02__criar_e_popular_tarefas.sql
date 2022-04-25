INSERT INTO departamento(id ,titulo) VALUES (1 ,'Financeiro');
INSERT INTO departamento(id ,titulo) VALUES (2 ,'Comercial');
INSERT INTO departamento(id ,titulo) VALUES (3 ,'Desenvolvimento');

INSERT INTO pessoa (id ,nome , departamento_id) VALUES (1 ,'Camila', 1 );
INSERT INTO pessoa (id ,nome , departamento_id) VALUES (2 ,'Pedro', 2 );
INSERT INTO pessoa (id ,nome , departamento_id) VALUES (3 ,'Fabiano', 3 );
INSERT INTO pessoa (id ,nome , departamento_id) VALUES (4 ,'Raquel', 3 );
INSERT INTO pessoa (id ,nome , departamento_id) VALUES (5 ,'Patricia', 3 );
INSERT INTO pessoa (id ,nome , departamento_id) VALUES (6 ,'Joaquim', 1 );


INSERT INTO tarefa (id, titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES (1001, 'Validar NF Janeiro', 'Validar notas recebidas no mês de Janeiro', DATE '2022/02/15', 1, 14, 1, 'TRUE');
INSERT INTO tarefa (id, titulo, descricao, prazo, departamento_id, duracao, finalizado) VALUES (1002, 'Bug 352', 'Corrigir bug 352 na versão 1.25', DATE '2022/05/10', 3, 25, 'FALSE');
INSERT INTO tarefa (id, titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES (1003, 'Liberação da versão 1.24', 'Disponibilizar pacote para testes', DATE '2022/02/02', 3, 2, 3, 'FALSE');
INSERT INTO tarefa (id, titulo, descricao, prazo, departamento_id, duracao, finalizado) VALUES (1004, 'Reunião A', 'Reunião com cliente A para apresentação do produto', DATE '2022/05/05', 2, 5, 'FALSE');
INSERT INTO tarefa (id, titulo, descricao, prazo, departamento_id, duracao, finalizado) VALUES (1005, 'Reunião final', 'Fechamento contrato', DATE '2022/03/28', 2, 6, 'FALSE');
INSERT INTO tarefa (id, titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES (1006, 'Pagamento 01/2022', 'Realizar pagamento dos fornecedores', DATE '2022/01/31', 1, 6, 1, 'FALSE');
INSERT INTO tarefa (id, titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES (1007, 'Bug 401', 'Corrigir bug 401 na versão 1.20', DATE '2022/01/01', 3, 2, 4, 'TRUE');
INSERT INTO tarefa (id, titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES (1008, 'Bug 399', 'Corrigir bug 399 na versão 1.20', DATE '2022/01/28', 3, 6, 5, 'TRUE');
INSERT INTO tarefa (id, titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES (1009, 'Reunião B', 'Reunião com cliente B para apresentação do produto', DATE '2022/01/31', 2, 5, 2, 'TRUE');
INSERT INTO tarefa (id, titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES (1010, 'Validar NF Fevereiro', 'Validar notas recebidas no mês de Fevereiro', DATE '2022/03/15', 1, 14, 6, 'FALSE');
INSERT INTO tarefa (id, titulo, descricao, prazo, departamento_id, duracao, finalizado) VALUES (1011, 'Bug 398', 'Corrigir bug 398 na versão 1.20', DATE '2022/01/28', 3, 6, 'FALSE');
