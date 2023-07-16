-- Criação da tabela "marcas"
CREATE TABLE marcas (
  id SERIAL PRIMARY KEY,
  cnpj VARCHAR(14) NOT NULL,
  razaoSocial VARCHAR(100) NOT NULL,
  cep VARCHAR(8) NOT NULL,
  rua VARCHAR(100) NOT NULL,
  numero VARCHAR(10) NOT NULL,
  bairro VARCHAR(100) NOT NULL,
  cidade VARCHAR(100) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  pais VARCHAR(100) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  email VARCHAR(100) NOT NULL,
  site VARCHAR(100) NOT NULL
);

-- Criação da tabela "modelos"
CREATE TABLE modelos (
  id SERIAL PRIMARY KEY,
  id_marca INT NOT NULL,
  nomeModelo VARCHAR(100) NOT NULL,
  potencia VARCHAR(50) NOT NULL,
  motor VARCHAR(50) NOT NULL,
  anoLancamento VARCHAR(4) NOT NULL,
  tipoCombustivel VARCHAR(50) NOT NULL,
  numeroPortas VARCHAR(2) NOT NULL,
  FOREIGN KEY (id_marca) REFERENCES marcas (id)
);

-- Criação da tabela "veiculos"
CREATE TABLE veiculos (
  idVeiculo SERIAL PRIMARY KEY,
  dataCadastroVeiculo DATE NOT NULL,
  chassi VARCHAR(17) NOT NULL,
  placa VARCHAR(7) NOT NULL,
  corVeiculo VARCHAR(50) NOT NULL,
  quilometragem VARCHAR(20) NOT NULL,
  codigoMarca INT NOT NULL,
  codigoModelo INT NOT NULL,
  FOREIGN KEY (codigoMarca) REFERENCES marcas (id),
  FOREIGN KEY (codigoModelo) REFERENCES modelos (id)
);

