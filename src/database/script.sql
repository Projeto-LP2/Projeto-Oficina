-- public.veiculo definição

-- Drop table

-- DROP TABLE public.veiculo;

CREATE TABLE public.veiculo (
	codigo serial4 NOT NULL,
	placa varchar(10) NOT NULL,
	modelo varchar(50) NOT NULL,
	marca varchar(50) NOT NULL,
	ano int4 NOT NULL,
	proprietario varchar(100) NOT NULL,
	telefone_proprietario varchar(20) NULL,
	descricao_servico varchar(255) NULL,
	CONSTRAINT veiculo_ano_not_null NOT NULL ano,
	CONSTRAINT veiculo_codigo_not_null NOT NULL codigo,
	CONSTRAINT veiculo_marca_not_null NOT NULL marca,
	CONSTRAINT veiculo_modelo_not_null NOT NULL modelo,
	CONSTRAINT veiculo_pkey PRIMARY KEY (codigo),
	CONSTRAINT veiculo_placa_not_null NOT NULL placa,
	CONSTRAINT veiculo_proprietario_not_null NOT NULL proprietario
);