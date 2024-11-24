package com.pyramid.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membros")
public class MembrosController {
	
	@GetMapping
	public String getMembros() {
		return "membros";
	}
}
