package com.EverDev.Leilao.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EverDev.Leilao.controller.dto.ConcorrenteDTO;
import com.EverDev.Leilao.controller.dto.LanceDTO;
import com.EverDev.Leilao.controller.dto.LeilaoDTO;
import com.EverDev.Leilao.model.Concorrente;
import com.EverDev.Leilao.model.Leilao;
import com.EverDev.Leilao.repository.ConcorrenteRepository;
import com.EverDev.Leilao.repository.LanceRespository;
import com.EverDev.Leilao.repository.LeilaoRepository;

@RestController
@RequestMapping("/vencedor_leilao")
public class VencedorLeilaoController {
	
	@Autowired
	private LeilaoRepository leilaoRepository;
	@Autowired
	private ConcorrenteRepository concorrenteRepository;
	@Autowired
	private LanceRespository respository;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getVencedorLeilao(@PathVariable Long id) {
		try {
			Leilao leilao = leilaoRepository.getReferenceById(id);
			List<LanceDTO> lances = respository.findByLeilaoId(id).stream().map(LanceDTO::new).collect(Collectors.toList());
			Long vencedorId = lances.get(0).getIdConcorrente();
			Double valorVencedor = lances.get(0).getValor();
			LanceDTO lancevencedor = lances.get(0);
			for (LanceDTO ls : lances) {
				if (ls.getValor() > valorVencedor) {
					vencedorId = ls.getIdConcorrente();
					valorVencedor = ls.getValor();
					lancevencedor = ls;
				}
			}
			if (leilao == null) {
				return ResponseEntity.notFound().build();
			}
			LeilaoDTO leilaoDTO = new LeilaoDTO(leilao);
			Concorrente vencedor = concorrenteRepository.getReferenceById(vencedorId);
			ConcorrenteDTO vencedorDTO = new ConcorrenteDTO(vencedor);			
			return ResponseEntity.ok(leilaoDTO);
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	

}
