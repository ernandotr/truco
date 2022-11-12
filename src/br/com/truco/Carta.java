// Define o tipo carta para o jogo de truco

package br.com.truco;

public class Carta implements Comparable<Carta>{

	private int valor;
	
	private String nome;
	
	public Carta(){}
	
	public Carta(String nome){
		this.nome = nome;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int compareTo(Carta o) {
		if (this.getValor() < o.getValor()) {
			return -1;
		}
		if (this.getValor() > o.getValor()) {
			return 1;
		}
		return 0;
	}
	
	
}
