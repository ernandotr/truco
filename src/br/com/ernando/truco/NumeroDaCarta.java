package br.com.ernando.truco;

public enum NumeroDaCarta {
	AS("A"),
	DOIS("2"),
	TRES("3"),
	QUATRO("4"),
	CINCO("5"),
	SEIS("6"),
	SETE("7"),
	DAMA("Q"),
	VALETE("J"),
	REI("K");
	
	private String descricao;
	
	private NumeroDaCarta(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
