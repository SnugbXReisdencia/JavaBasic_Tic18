package com.EverDev.CompaniaAerea.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EverDev.CompaniaAerea.controller.dto.ModeloAeronaveDTO;
import com.EverDev.CompaniaAerea.model.ModeloAeronave;
import com.EverDev.CompaniaAerea.repository.ModeloAeronaveRepository;

@RestController
public class ModeloAeronaveController {
	
	@Autowired
	private ModeloAeronaveRepository modeloAeronaveRepository;
		
	@RequestMapping("/modeloAeronave/")
	public List<ModeloAeronaveDTO> getModeloAeronave(String fabricante) {
		List<ModeloAeronave> modeloAeronaves;
		if (fabricante != null) {
			modeloAeronaves = modeloAeronaveRepository.findByFabricante(fabricante);
		}else {
			modeloAeronaves = modeloAeronaveRepository.findAll();
		}
		
		return modeloAeronaves.stream().map(ModeloAeronaveDTO::new).collect(Collectors.toList());
	}
	
}
