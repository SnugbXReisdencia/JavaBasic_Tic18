package com.controleacademico.controleacademico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Hello World Everlan !";
	}
	
	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "Japão";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String login() {
		return "Login";
	}
}
