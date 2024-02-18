package com.redesocial.redesocial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.redesocial.controller.dto.UserDTO;
import com.redesocial.redesocial.model.Usuario;
import com.redesocial.redesocial.model.repository.UsuarioRepository;

@RestController
public class UsuarioController{
	String view = "";
	
	@Autowired
	UsuarioRepository userRepository;

	public UsuarioController() {
		view = "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">";
	}
	
	@RequestMapping("/listarUsuario")
	public String listar(){
		List<Usuario> usuarios = (ArrayList<Usuario>) userRepository.findAll();
		List<UserDTO> users = new ArrayList<UserDTO>();
		for (Usuario user : usuarios) {
			UserDTO userDTO = new UserDTO(user);
			users.add(userDTO);
		}
		String retorno = view;
		retorno += "<div class=\"container\">";
		retorno += "<div class=\"row\">";
		retorno += "<div class=\"col\">";
		retorno += "<table class=\"table\">";
		retorno += "<thead>";
		retorno += "<tr>";
		retorno += "<th scope=\"col\">Nome</th>";
		retorno += "<th scope=\"col\">Email</th>";
		retorno += "</tr>";
		retorno += "</thead>";
		retorno += "<tbody>";
		for (UserDTO user : users) {
			retorno += "<tr>";
			retorno += "<td>" + user.getName() + "</td>";
			retorno += "<td>" + user.getEmail() + "</td>";
			retorno += "</tr>";
		}
		retorno += "</tbody>";
		retorno += "</table>";
		retorno += "</div>";
		retorno += "</div>";
		retorno += "</div>";
		return retorno;
	}
	
}
