CREATE DATABASE webService;

/connect webService;

CREATE TABLE contratos (
    id SERIAL PRIMARY KEY,
    nome_devedor VARCHAR(255) NOT NULL,
    data_nascimento_devedor DATE NOT NULL,
    numero_registro_eletronico VARCHAR(255) NOT NULL
);


CREATE TABLE veiculos (
    id SERIAL PRIMARY KEY,
    numero_gravame VARCHAR(255) NOT NULL,
    numero_renavam VARCHAR(255) NOT NULL,
    placa VARCHAR(10) NOT NULL,
    numero_chassi VARCHAR(255) NOT NULL,
    contrato_id INTEGER NOT NULL,
    FOREIGN KEY (contrato_id) REFERENCES contratos (id)
);