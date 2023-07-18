-- Criação da tabela "veiculos"
CREATE TABLE veiculos (
  id SERIAL PRIMARY KEY,
  chassi VARCHAR(17) NOT NULL UNIQUE,
  placa VARCHAR(7) NOT NULL UNIQUE,
  corVeiculo VARCHAR(50) NOT NULL,
  quilometragem VARCHAR(20) NOT NULL
);

-- Criação da tabela "modelos"
CREATE TABLE modelos (
  id SERIAL PRIMARY KEY,
  id_veiculo INT NOT NULL,
  nomeModelo VARCHAR(100) NOT NULL,
  motor VARCHAR(50) NOT NULL,
  potencia VARCHAR(50) NOT NULL,
  anoLancamento VARCHAR(4) NOT NULL,
  tipoCombustivel VARCHAR(50) NOT NULL,
  numeroPortas VARCHAR(2) NOT NULL,
  FOREIGN KEY (id_veiculo) REFERENCES veiculos (id)
);

-- Criação da tabela "marcas"
CREATE TABLE marcas (
  id SERIAL PRIMARY KEY,
  id_modelo INT NOT NULL,
  cnpj VARCHAR(14) NOT NULL UNIQUE,
  razaoSocial VARCHAR(100) NOT NULL,
  cep VARCHAR(8) NOT NULL,
  ruaNumero VARCHAR(100) NOT NULL,
  bairro VARCHAR(100) NOT NULL,
  cidade VARCHAR(100) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  pais VARCHAR(100) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  email VARCHAR(100) NULL,
  site VARCHAR(100) NULL,
  FOREIGN KEY (id_modelo) REFERENCES modelos (id)
);

-- Inserir
-- Veículo
INSERT INTO veiculos (chassi, placa, corVeiculo, quilometragem)
VALUES ('ChassiTeste', 'PlacaTe', 'corVeiculo', '100.000');
-- Modelo
INSERT INTO modelos (id_veiculo, nomeModelo, motor, potencia, anoLancamento, tipoCombustivel, numeroPortas) 
VALUES ( 2, 'Gol', '16', '16', '2023', 'gasolina', '4');
-- Marca
INSERT INTO marcas (id_modelo, cnpj, razaoSocial, cep, ruaNumero, bairro, cidade, uf, pais, telefone, email, site) 
VALUES ( 1, 'CNPJ', 'Razão Social', '88888000', 'Rua e Número', 'Bairro', 'Cidade', 'UF', 'País', '99999999', 'Email', 'Site');

-- Consultar Tabelas
SELECT * FROM veiculos;
SELECT * FROM modelos;
SELECT * FROM marcas;

-- Excluir Tabelas
DROP TABLE marcas;
DROP TABLE modelos;
DROP TABLE veiculos;
























