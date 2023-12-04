package Model;

public abstract class Parada {
	private String nome;
	private String CEP;
	private String Cidade;
	private String UF;
	
	public Parada(String nome, String CEP, String Cidade, String UF) {
		this.nome = nome;
		this.CEP = CEP;
		this.Cidade = Cidade;
		this.UF = UF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}
	

}
