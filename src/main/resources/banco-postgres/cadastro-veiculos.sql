-- Criação da tabela "marcas"
CREATE TABLE marcas (
  id SERIAL PRIMARY KEY,
  cnpj VARCHAR(14) NOT NULL UNIQUE,
  razao_social VARCHAR(100) NOT NULL,
  cep VARCHAR(8) NOT NULL, 
  rua_numero VARCHAR(100) NOT NULL,
  bairro VARCHAR(100) NOT NULL,
  cidade VARCHAR(100) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  pais VARCHAR(100) NOT NULL,
  telefone VARCHAR(13) NOT NULL, -- +55 48 98888 0000
  email VARCHAR(100) NULL,
  site VARCHAR(100) NULL
);

-- Criação da tabela "modelos"
CREATE TABLE modelos (
  id SERIAL PRIMARY KEY,
  id_marca INT NOT NULL,
  nome_modelo VARCHAR(100) NOT NULL,
  motor VARCHAR(50) NOT NULL,
  potencia VARCHAR(50) NOT NULL,
  ano_lancamento NUMERIC(4) NOT NULL,
  tipo_combustivel VARCHAR(50) NOT NULL,
  numero_portas NUMERIC(2) NOT NULL,
  FOREIGN KEY (id_marca) REFERENCES marcas (id)
);

-- Criação da tabela "veiculos"
CREATE TABLE veiculos (
  id SERIAL PRIMARY KEY,
  id_modelo INT NOT NULL,
  chassi VARCHAR(17) NOT NULL UNIQUE,
  placa VARCHAR(7) NOT NULL UNIQUE,
  cor_veiculo VARCHAR(50) NOT NULL,
  quilometragem NUMERIC(8) NOT NULL, -- 10.000.000
  FOREIGN KEY (id_modelo) REFERENCES modelos (id)
);




























