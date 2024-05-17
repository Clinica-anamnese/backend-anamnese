CREATE TABLE paciente (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(60) NOT NULL,
    sexo ENUM('masculino', 'feminino', 'nao_informado') NOT NULL,
    data_nascimento DATE NOT NULL,
    criado_em DATE DEFAULT (CURRENT_DATE) NOT NULL
);

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(60) NOT NULL,
    matricula VARCHAR(10) NOT NULL UNIQUE,
    senha VARCHAR(60) NOT NULL,
    user_role ENUM('ADMIN', 'USER') NOT NULL,
    criado_em DATE DEFAULT (CURRENT_DATE) NOT NULL
);

CREATE TABLE anamnese (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    paciente_id INT NOT NULL,
    paciente_nome VARCHAR(60) NOT NULL,
    escolaridade ENUM('fundamental_completo', 'ensino_medio_completo', 'ensino_superior_incompleto', 'ensino_superior_completo', 'outra') NOT NULL,
    periodo_estudo ENUM('manha', 'tarde', 'noite', 'NA') NOT NULL,
    lanche_estudo BOOLEAN NOT NULL,
    periodo_trabalho ENUM('manha', 'tarde', 'noite', 'NA') NOT NULL,
    lanche_trabalho BOOLEAN NOT NULL,
    profissao VARCHAR(60) NOT NULL,
    renda_familiar ENUM('menos_de_1_salario_minimo', 'de_1_a_2_salarios_minimos', 'de_3_a_5_salarios_minimos', 'mais_de_5_salarios_minimos', 'nao_sei') NOT NULL,
    num_pessoas_domicilio INT NOT NULL,
    motivo TEXT NOT NULL,
    apresenta_doenca TEXT,
    antecedentes_familiares TEXT,
    medicamentos_continuos TEXT,
    suplementos_complementos TEXT,
    frequencia_evacuacao ENUM('diaria', 'alternada', 'tres_vezes_por_semana', 'menos_de_3_vezes_por_semana') NOT NULL,
    consistencia_evacuacao INT NOT NULL,
    pratica_atv_fisica BOOLEAN NOT NULL,
    atv_fisica TEXT,
    criado_em DATE DEFAULT (CURRENT_DATE) NOT NULL,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

INSERT INTO usuario (nome, matricula, senha, user_role)
VALUES ('admin', 'admin', '$2a$12$nYYxMYVyQirARNSQBGLGOuVq7HAZkS9rJh7JmvUnKldrBkH1aFlSe', 'ADMIN');
