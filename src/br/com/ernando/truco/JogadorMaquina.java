package br.com.ernando.truco;

import java.util.Collections;

import javax.swing.JOptionPane;

public class JogadorMaquina extends Jogador {

	@Override
	public void jogar() {
		if (getCartas().size() == 3) {
			Collections.sort(this.cartas);
			int x = (int) (Math.random() * 3);
			
			setUltimaJogaga(getCartas().remove(x));
		}else {
			if(!isVenceuPrimeiraMao() && this.cartas.size() == 2){
				setUltimaJogaga(getCartas().remove(1));
			}else{
				setUltimaJogaga(getCartas().remove(0));
			}
		}
		JOptionPane.showMessageDialog(null, getNome()+" jogou a carta : "+ getUltimaJogaga().getNome());
		
	}	
}
