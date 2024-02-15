package com.EverDev.Formula1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Vencedor_controller {
	@GetMapping("/vencedor")
	public String vencedor() {
		return "Ola, eu sou Everlan e eu sou o vencedor";
	}
}
