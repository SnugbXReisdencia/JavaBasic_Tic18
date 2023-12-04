package Model;

public class Motorista extends Pessoa {
	private String CNH;
	
	public Motorista(String nome, String cpf , String CNH) {
		super(nome, cpf);
		this.CNH = CNH;
	}
	
	public String getCNH() {
		return CNH;
	}
	
	public void setCNH(String CNH) {
		this.CNH = CNH;
	}

	@Override
	public String toString() {
		return "Motorista [CNH=" + CNH + "]";
	}
	
	
}
