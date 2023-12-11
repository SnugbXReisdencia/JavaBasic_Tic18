package ClienteExcercoes;

public class AutenticacaoFalhouException extends RuntimeException{
	 String senha;
	 
	 public AutenticacaoFalhouException(String senha) {
		 this.senha = senha;
	 }
	 
	 public String getMessage() {
		 return "A senha não está correta.";
	 }
}
