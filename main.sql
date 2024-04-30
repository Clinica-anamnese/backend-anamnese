-- Active: 1706151844325@@127.0.0.1@3306@main
CREATE TABLE paciente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    data_nascimento DATE NOT NULL,
    sexo ENUM('masculino', 'feminino', 'nao_informado') NOT NULL,
    criado_em DATE DEFAULT CURRENT_DATE
);

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    matricula INTEGER NOT NULL,
    senha VARCHAR NOT NULL,
    adm TINYINT(1) NOT NULL,
    ativo TINYINT(1) NOT NULL,
    criado_em DATE DEFAULT CURRENT_DATE
);
