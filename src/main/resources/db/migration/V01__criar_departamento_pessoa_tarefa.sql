CREATE SCHEMA IF NOT EXISTS  public;
CREATE TABLE public.departamento (
    id INT PRIMARY KEY,
    titulo VARCHAR(50)
);

CREATE TABLE public.pessoa (
                        id INT PRIMARY KEY,
                        nome VARCHAR(100),
                        departamento_id INT
);

CREATE TABLE public.tarefa (
                        id INT PRIMARY KEY,
                        titulo VARCHAR(50),
                        descricao VARCHAR(100),
                        prazo DATE,
                        departamento_id INT,
                        duracao INT,
                        pessoa_id INT,
                        finalizado BOOLEAN
);

ALTER TABLE public.pessoa ADD CONSTRAINT fk_pessoa_departamento FOREIGN KEY (departamento_id) REFERENCES public.departamento (id);

ALTER TABLE public.tarefa ADD CONSTRAINT fk_tarefa_departamento FOREIGN KEY (departamento_id) REFERENCES public.departamento(id);
ALTER TABLE public.tarefa ADD CONSTRAINT fk_tarefa_pessoa FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);



