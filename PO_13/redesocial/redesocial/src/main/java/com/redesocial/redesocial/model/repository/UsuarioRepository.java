package com.redesocial.redesocial.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redesocial.redesocial.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	List<Usuario> findByName(String name);
	
}
