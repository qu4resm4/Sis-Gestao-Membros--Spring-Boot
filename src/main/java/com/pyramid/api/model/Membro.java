package com.pyramid.api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Ajuste de tipo para `Long` para melhor compatibilidade com o banco.

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf; // Mantido como String, mas validado para conter exatamente 11 dígitos.

    @Column(nullable = false, length = 1)
    private Character genero; // Ajustado para Character, refletindo melhor o tipo CHAR(1) no banco.

    @Column(name = "data_nascimento", columnDefinition = "DATE")
    private LocalDate dataNascimento; // Ajustado para LocalDate para mapeamento correto de DATE.

    @Embedded
    private Endereco endereco; // Mapeamento de uma entidade embutida.

    @Column(length = 15)
    private String telefone; // Mantido como String para formatar e armazenar telefone.

    @Column(name = "data_contratacao", columnDefinition = "DATE")
    private LocalDate dataContratacao; // Ajustado para LocalDate.

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(name = "setor_id", nullable = false)
    private Long setorId; // Ajuste para Long.

    @Column(name = "ultimo_login", columnDefinition = "TIMESTAMP")
    private LocalDateTime ultimoLogin; // Ajustado para LocalDateTime.

    @Column(name = "funcao_id", nullable = false)
    private Long funcaoId; // Ajuste para Long.

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Perfil perfil; // Enum ajustado com mapeamento para String no banco.

    @Column(name = "criado_por_id")
    private Long criadoPorId; // Ajuste para Long.

    @Column(name = "criado_em", columnDefinition = "TIMESTAMP", updatable = false)
    private LocalDateTime criadoEm; // Ajustado para LocalDateTime.

    @Column(name = "atualizado_por", length = 255)
    private String atualizadoPor;

    @Column(name = "atualizado_em", columnDefinition = "TIMESTAMP")
    private LocalDateTime atualizadoEm; // Ajustado para LocalDateTime.

    @Column(nullable = false)
    private Boolean ativo;

    @Column(name = "desativado_em", columnDefinition = "TIMESTAMP")
    private LocalDateTime desativadoEm; // Ajustado para LocalDateTime.

    @Column(name = "desativado_por", length = 255)
    private String desativadoPor;
}
