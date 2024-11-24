package com.pyramid.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "membros")
@Entity(name = "Membro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Membro {
	
	/**
	 *     id SERIAL PRIMARY KEY,                          -- Identificador único
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
	 * 
	 * 
	 * /
	
}
