package com.redesocial.redesocial.controller.dto;

import com.redesocial.redesocial.model.Usuario;

public class UserDTO {

	Usuario user;
	private String name;
	private String email;
	private String senha;
	
	public UserDTO(Usuario user) {
		this.user = user;
		this.name = user.getName();
		this.email = user.getEmail();
		this.senha = user.getSenha();
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	@Override
	public String toString() {
		return "[\n name=" + name + "\n email=" + email + "\n senha=" + senha + "\n]";
	}
	
	
}
