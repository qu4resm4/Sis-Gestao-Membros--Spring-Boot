package com.pyramid.api.dto;

import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/*
 * lembrar de por @Valid no serviço que for chamar o repository para salvar no db repository.save */

public record DadosCadastroMembros (
		
		@NotBlank 
		String nome,
		
		@NotBlank
			@Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos numéricos.")
		String cpf,

		@NotBlank
		@Email
		String email,
		
		@NotBlank
		String senha,
		
		@NotBlank
		String telefone,
		
		@NotNull
		LocalDate data_nascimento,
		
		@NotNull
		@Valid
		DadosEndereco endereco,
		
		@NotBlank
		String data_contratacao,
		
		@NotBlank
			@Pattern(regexp = "[MF]", message = "O gênero deve ser 'M' para masculino ou 'F' para feminino.")
		String genero
		
		) {}
