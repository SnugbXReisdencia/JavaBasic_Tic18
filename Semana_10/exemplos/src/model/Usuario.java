package model;

public class Usuario {
	private String nome;
	private String senha;
	private String email;
	
	public Usuario(String nome, String senha, String email) {
		setNome(nome);
		setSenha(senha);
		setEmail(email);
	}
	public Usuario() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return "\nNome: " + nome + "\nSenha: " + senha + "\nEmail: " + email+ "\n----------------------------------------\n";
	}
}
