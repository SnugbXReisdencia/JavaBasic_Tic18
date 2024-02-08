package com.controleacademico.controleacademico.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleacademico.controleacademico.modelo.User;

//@Controller
@RestController
public class UserController {
	@RequestMapping("/listar")
//	@ResponseBody
	public List<User> Listar() {
		List<User> list = new ArrayList<>();
		list.add(new User("João", "joao@joao", "123"));
		list.add(new User("Maria", "maria@maria", "123"));
		list.add(new User("Pedro", "pedro@pedro", "123"));
		list.add(new User("José", "jose@jose", "123"));
		list.add(new User("Ana", "ana@ana", "123"));
		return list;
	}
	
	@RequestMapping("/oi")
//	@ResponseBody
	public String oi() {
//		Dados do arquivo
		File f = new File("oi.txt");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = "";
		
		return s;
	}
}
