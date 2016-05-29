package br.com.ernando.truco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {

	private List<Carta> cartas =  new ArrayList<Carta>();
	
	public void carregarBaralho(){
		for(Naipes naipe :  Naipes.values()){
			for(NumeroDaCarta numero : NumeroDaCarta.values()){
				Carta carta = new Carta(numero.getDescricao().concat(" de ").concat(naipe.getDescicao()));
				switch (numero.getDescricao()) {
				case "4":{
					if(Naipes.PAUS.equals(naipe))
						carta.setValor(15);
					else {
						carta.setValor(2);
					}
					break;
				}
				case "7":{
					if(Naipes.COPAS.equals(naipe))
						carta.setValor(14);
					else if(Naipes.OUROS.equals(naipe)) {
						carta.setValor(12);
					}else {
						carta.setValor(5);
					}
					break;
				}	
				case "A":{
					if(Naipes.ESPADAS.equals(naipe))
						carta.setValor(13);
					else {
						carta.setValor(9);
					}
					break;
				}
				case "3":{
					carta.setValor(11);
					break;
				}
				case "2":{
					carta.setValor(10);
					break;
				}
				case "K":{
					carta.setValor(8);
					break;
				}
				case "J":{
					carta.setValor(7);
					break;
				}
				case "Q":{
					carta.setValor(6);
					break;
				}
				case "6":{
					carta.setValor(4);
					break;
				}
				case "5":{
					carta.setValor(3);
					break;
				}
				default:
					break;
				}
				cartas.add(carta);
			}
		}
	}
	
	public void embaralhar(){
		 Collections.shuffle(cartas);
	}
	
	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

}
