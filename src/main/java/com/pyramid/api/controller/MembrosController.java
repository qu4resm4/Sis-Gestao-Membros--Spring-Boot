package com.pyramid.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("membros")
public class MembrosController {
	
	@PostMapping
	/*@Transactional*/
	public ResponseEntity cadastrarMembros() {
		
		return ResponseEntity.ok().body(DTO);
	}
	
	@GetMapping
	public String getMembros() {
		return "membros";
	}
}
