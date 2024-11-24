CREATE TABLE setor (
    id SERIAL PRIMARY KEY,                      -- Identificador único
    nome VARCHAR(100) NOT NULL,                   -- Nome do setor
    descricao TEXT,                               -- Breve descrição do setor
    nivel_hierarquico VARCHAR(20) NOT NULL,       -- Nível hierárquico (Estratégico, Tático, Operacional)
    id_subordinado_a INTEGER,                          -- Referência a um setor a qual é subordinado (hierarquia)
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- Data de criação
    atualizado_em TIMESTAMP,                      -- Data da última atualização
    
    -- Relacionamento opcional com o setor a qual é subordinado
    CONSTRAINT fk_id_subordinado_a FOREIGN KEY (id_subordinado_a) REFERENCES setor (id) ON DELETE SET NULL
);

-- Inserção do valor padrão para setor_id (id = 1)
INSERT INTO setor (id, nome, descricao, nivel_hierarquico, criado_em)
VALUES 
(1, 'Sem setor associado', 'Setor padrão para membros sem setor específico associado', 'Nenhum', CURRENT_TIMESTAMP);



CREATE TABLE funcao (
    id SERIAL PRIMARY KEY,                      -- Identificador único
    nome VARCHAR(100) NOT NULL,                   -- Nome da função
    descricao TEXT,                               -- Breve descrição da função
    nivel_hierarquico VARCHAR(20) NOT NULL,       -- Nível hierárquico (Estratégico, Tático, Operacional)
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- Data de criação
    atualizado_em TIMESTAMP                      -- Data da última atualização
);

-- Inserção do valor padrão para funcao_id (id = 1)
INSERT INTO funcao (id, nome, descricao, nivel_hierarquico, criado_em)
VALUES 
(1, 'Sem função associada', 'Função padrão para membros sem função específica associada', 'Nenhum', CURRENT_TIMESTAMP);



-- Criação da tabela membros
CREATE TABLE membros (
    id SERIAL PRIMARY KEY,                          -- Identificador único
    nome VARCHAR(255) NOT NULL,                       -- Nome completo do membro
    cpf VARCHAR(11) NOT NULL UNIQUE,                 -- CPF único (formato sem máscara)
    email VARCHAR(255) NOT NULL UNIQUE,              -- Email único
    telefone VARCHAR(15),                            -- Telefone para contato
    setor_id INTEGER NOT NULL DEFAULT 1,             -- Relacionamento com setores
    funcao_id INTEGER NOT NULL DEFAULT 1,            -- Relacionamento com funções
    perfil VARCHAR(50) NOT NULL,                    -- Perfil do membro (RH, Estratégico, Tático ou Operacional.)
    senha VARCHAR(255) NOT NULL,                    -- Senha criptografada
    ativo BOOLEAN NOT NULL DEFAULT TRUE,            -- Indica se o membro está ativo no sistema
    ultimo_login TIMESTAMP,                         -- Último login do membro
    data_nascimento DATE,                           -- Data de nascimento do membro
    
    logradouro VARCHAR(255) NOT NULL,            -- Nome da rua, avenida, etc.
    numero VARCHAR(10) NOT NULL,                 -- Número da residência (ou "S/N")
    complemento VARCHAR(255),                    -- Informação adicional (ex.: bloco, apto)
    bairro VARCHAR(100) NOT NULL,                -- Bairro
    cidade VARCHAR(100) NOT NULL,                -- Cidade
    estado VARCHAR(2) NOT NULL,                  -- Estado UF (ex.: "SP", "RJ")
    cep VARCHAR(9) NOT NULL,                     -- CEP no formato "#####-###"
    
    data_contratacao DATE,                          -- Data de início no cargo
    criado_por_id INTEGER,       					-- Quem criou o registro
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data/hora da criação
    atualizado_por VARCHAR(255),                   -- Quem fez a última atualização
    atualizado_em TIMESTAMP,                       -- Data/hora da última atualização
    desativado_em TIMESTAMP,                       -- Data/hora da desativação
    desativado_por VARCHAR(255),                   -- Quem desativou o membro
    genero CHAR(1) NOT NULL,      
    
    
    CONSTRAINT fk_setor FOREIGN KEY (setor_id) REFERENCES setor (id) ON DELETE SET DEFAULT,
    CONSTRAINT fk_funcao FOREIGN KEY (funcao_id) REFERENCES funcao (id) ON DELETE SET DEFAULT,
    CONSTRAINT fk_criador_registro FOREIGN KEY (criado_por_id) REFERENCES membros (id) ON DELETE SET NULL
);