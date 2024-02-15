package com.EverDev.Formula1.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EverDev.Formula1.model.Piloto;
import com.EverDev.Formula1.util.LeitorCSV;

@RestController
public class Piloto_Controller {
	
	private List<Piloto> pilotos;
	private String vencedor = "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">";
	private String retorno;
	public Piloto_Controller() throws IOException {
		vencedor += "<H1>Pilotos Formula 1</H1><br>";
		this.pilotos = LeitorCSV.listaPilotos();
	}
	
	@GetMapping("/todos")
	public String vencedor() throws IOException {
		vencedor += "<H1>Pilotos Formula 1</H1><br>";
		vencedor += "<h2>Lista de todos os pilotos:</h2>";
		vencedor += "<table class=\"table table-striped\">";
		vencedor += "<tr><th>Nome</th><th>Pais</th><th>Vitorias</th></tr>";
		this.pilotos.forEach(piloto -> {
			vencedor += "<tr><td>" + piloto.getNome() + "</td><td>" + piloto.getPais() + "</td><td>" + piloto.getVitorias() + "</td></tr>";
		});
		vencedor += "</table>";
		return vencedor;
	}
	
	@GetMapping("/brasileiros")
	public String brasileiros() throws IOException {
		retorno = vencedor;
		retorno += "<h2>Pilotos Brasileiros:</h2>";
		retorno += "<table class=\"table\">";
		retorno += "<thead class=\"table-dark\">";
		retorno += "<tr><th>Nome</th><th>Pais</th><th>Vitorias</th></tr>";
		retorno += "</thead>";
		pilotos.forEach(piloto -> {
			if (piloto.getPais().equalsIgnoreCase("Brasil")) {
				retorno += "<tr><td>" + piloto.getNome() + "</td><td>" + piloto.getPais() + "</td><td>" + piloto.getVitorias() + "</td></tr>";
			}
		});
		retorno += "</table>";
		return retorno;
	}
	
	@GetMapping("/top5")
	public String top5() throws IOException {
		retorno = vencedor;
		retorno += "<h2>Top 5 dos pilotos com mais vitorias:</h2>";
		retorno += "<table class=\"table table-dark table-hover\">";
		retorno += "<tr><th>Nome</th><th>Pais</th><th>Vitorias</th></tr>";
		pilotos.sort((p1, p2) -> p2.getVitorias() - p1.getVitorias());
		for (int i = 0; i < 5; i++) {
			retorno += "<tr><td>" + pilotos.get(i).getNome() + "</td><td>" + pilotos.get(i).getPais() + "</td><td>" + pilotos.get(i).getVitorias() + "</td></tr>";
		}
		retorno += "</table>";
		return retorno;
	}
	
	@GetMapping("/top10")
	public String top10() throws IOException {
		retorno = vencedor;
		retorno += "<h2>Top 5 dos pilotos com mais vitorias:</h2>";
		retorno += "<table class=\"table table-striped table-hover\">";
		retorno += "<tr><th>Nome</th><th>Pais</th><th>Vitorias</th></tr>";
		pilotos.sort((p1, p2) -> p2.getVitorias() - p1.getVitorias());
		for (int i = 0; i < 10; i++) {
			retorno += "<tr><td>" + pilotos.get(i).getNome() + "</td><td>" + pilotos.get(i).getPais() + "</td><td>" + pilotos.get(i).getVitorias() + "</td></tr>";
		}
		retorno += "</table>";
		return retorno;
	}
	
}
