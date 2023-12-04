package Model;

import java.util.ArrayList;

public class Passageiro extends Pessoa{
	
	private String Numero_Cartao;
	private ArrayList<Embarque> embarques;
	
	public Passageiro(String nome, String cpf, String Numero_Cartao) {
		super(nome, cpf);
		this.Numero_Cartao = Numero_Cartao;
	}

	public String getNumero_Cartao() {
		return Numero_Cartao;
	}

	public void setNumero_Cartao(String numero_Cartao) {
		Numero_Cartao = numero_Cartao;
	}

	public ArrayList<Embarque> getEmbarques() {
		return embarques;
	}

	public void addEmbarque(Embarque embarque) {
		this.embarques.add(embarque);
	}
	
	
	
	
}
