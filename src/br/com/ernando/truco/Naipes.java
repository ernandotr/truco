package br.com.ernando.truco;

public enum Naipes {
	OUROS("\u2662"),
	ESPADAS("\uu2660"),
	COPAS("\uu2661"),
	PAUS("\u2663");
	
	private String descicao;
	
	private Naipes(String descricao){
		this.descicao = descricao;
	}
	
	public String getDescicao() {
		return descicao;
	}
}
