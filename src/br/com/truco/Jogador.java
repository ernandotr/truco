package br.com.truco;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public abstract  class Jogador {

	protected List<Carta> cartas = new ArrayList<Carta>();
	
	private Carta ultimaJogaga;
	
	private byte pontos;
	
	private String nome;
	
	private boolean venceuPrimeiraMao;
	
	private boolean venceuMaoAtual;

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public Carta getUltimaJogaga() {
		return ultimaJogaga;
	}

	public void setUltimaJogaga(Carta ultimaJogaga) {
		this.ultimaJogaga = ultimaJogaga;
	}
	
	public byte getPontos() {
		return pontos;
	}

	public void setPontos(byte pontos) {
		this.pontos = pontos;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isVenceuPrimeiraMao() {
		return venceuPrimeiraMao;
	}

	public void setVenceuPrimeiraMao(boolean venceuPrimeiraMao) {
		this.venceuPrimeiraMao = venceuPrimeiraMao;
	}

	public boolean isVenceuMaoAtual() {
		return venceuMaoAtual;
	}

	public void setVenceuMaoAtual(boolean venceuMaoAtual) {
		this.venceuMaoAtual = venceuMaoAtual;
	}

	abstract void jogar();
	
	public void trucar(){
		JOptionPane.showMessageDialog(null, getNome() + "Está trucando...");
	}
}
