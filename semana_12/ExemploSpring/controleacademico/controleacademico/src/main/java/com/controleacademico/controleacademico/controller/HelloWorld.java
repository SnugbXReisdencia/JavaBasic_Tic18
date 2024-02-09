package com.controleacademico.controleacademico.controller;

import java.math.BigInteger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleacademico.controleacademico.controller.rsa.Key;
import com.controleacademico.controleacademico.controller.rsa.RSAGenerator;

@RestController
public class HelloWorld {
	
	private int primo = 2;
	private int sequencia = 0;
	private Key keypub;
	private Key keypriv;
	private String msg;
	private BigInteger n;
	
	@RequestMapping("/")	
	public String hello() {
		return "Hello World Everlan !";
	}
	
//	Gerador de chaves RSA
	@RequestMapping("/gerachave")
	public String gerachave() {
		RSAGenerator rsagenerator = new RSAGenerator(32);
		msg = "juca";
		keypub = rsagenerator.getPublickey();
		keypriv = rsagenerator.getPrivatekey();
		n = rsagenerator.encrypt(msg);
		String result = "Chave publica: "+keypub.toString()+"\nChave privada: "+keypriv.toString()+"\n";
		result += "Mensagem criptografada: "+n+"\n";
		result += "Mensagem descriptografada: "+myToString(rsagenerator.decrypt(n))+"\n";
		result += "Mensagem original: "+msg;
		return result;
	}
	
	private String myToString(BigInteger bi) {
		byte[] bytes = bi.toByteArray();
		String sb = new String();
		for (int i = 0; i < bytes.length; i++) {
			char c = (char) bytes[i];
			sb += c;
		}
		return sb;
	}
	
	@RequestMapping("/home")
	public String home() {
		return "Japão";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "Login";
	}
	
//	gerar numeros aleatorios
	@RequestMapping("/aleatorio")
//	@ResponseBody
	public int aleatorio() {
		//retorna um numero inteiro aleatorio
		int aleatorio = (int) (Math.random() * 100);
		return aleatorio;
	}
	
//	Gerador de numeros em sequencia
	@RequestMapping("/sequencia")
//	@ResponseBody
	public int sequencia() {
		return sequencia++;
	}
	
////	Gerador de numeros em sequencia primeiros
//	@RequestMapping("/sequenciaprimeiros")
//	public int sequenciaprimeiros() {
//		int cont = 0;
//		int anterior = primo;
//		for (int i = 1; i < anterior; i++) {
//			if (anterior % i == 0) {
//				cont++;
//			}
//		}
//		if (cont == 2) {
//			primo++;
//			return anterior;
//		}
//		primo++;
//		return anterior;
//	}
	
}
