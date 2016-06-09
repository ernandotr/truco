package br.com.truco;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class JogadorUsuario extends Jogador{

	Scanner input = new Scanner(System.in);
	
	@Override
	public void jogar() {
		StringBuilder info = new StringBuilder(">>> Suas cartas <<<\n");
		for(Carta carta : cartas){
			info.append(String.valueOf(getCartas().indexOf(carta))+" - " + carta.getNome()+ " \n");
		}
		int op = Integer.valueOf(JOptionPane.showInputDialog("Informe uma das opções a seguir:\n".concat(info.toString())));
		while(op < 0 || op >= cartas.size()){
			op = Integer.valueOf(JOptionPane.showInputDialog("Opção inválida!\n Informe uma das opções a seguir:\n".concat(info.toString())));
		}
		this.setUltimaJogaga(getCartas().remove(op));
//		System.out.println(getNome()+" jogou a carta :"+ getUltimaJogaga().getNome());
		
	}

}
