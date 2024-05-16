/* CREATE TABLE paciente (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(60) NOT NULL,
    sexo VARCHAR(30) NOT NULL,
    data_nascimento DATE NOT NULL,
    criado_em DATE DEFAULT (CURRENT_DATE) NOT NULL
); */

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(60) NOT NULL,
    matricula VARCHAR(10) NOT NULL UNIQUE,
    senha VARCHAR(60) NOT NULL,
    user_role ENUM('ADMIN', 'USER') NOT NULL,
    criado_em DATE DEFAULT (CURRENT_DATE) NOT NULL
);

/* CREATE TABLE anamnese (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    pergunta VARCHAR(60) NOT NULL,
    paciente_id INT NOT NULL,
    criado_em DATE DEFAULT (CURRENT_DATE) NOT NULL,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id)
); */

INSERT INTO usuario (nome, matricula, senha, user_role)
VALUES ('admin', 'admin', '$2a$12$nYYxMYVyQirARNSQBGLGOuVq7HAZkS9rJh7JmvUnKldrBkH1aFlSe', 'ADMIN');
