package com.EverDev.CompaniaAerea.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EverDev.CompaniaAerea.controller.dto.PilotoDTO;
import com.EverDev.CompaniaAerea.model.Piloto;
import com.EverDev.CompaniaAerea.repository.PilotoRepository;

@RestController
public class PilotoController {
	
	@Autowired
	private PilotoRepository pilotoRepository;
	
	@RequestMapping("/pilotos")
	public List<PilotoDTO> getPilotos() {
		List<Piloto> pilotos = pilotoRepository.findAll();
		return pilotos.stream().map(PilotoDTO::new).collect(Collectors.toList());
	}
}