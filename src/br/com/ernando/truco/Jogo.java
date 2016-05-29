package br.com.ernando.truco;

import javax.swing.JOptionPane;

public class Jogo {
	
	private Jogador jogadorA;
	private Jogador jogadorB;
	private static Baralho baralho;
	private  int contA;
	private int contB;
	

	public static void main(String[] args) {
		String mensagem = "Jogo de truco virtual. V1.0 \nDesenvolvido por: \nErnando Rezende, Eloah Lima e Ederley Rodrigues. ";
		
		JOptionPane.showMessageDialog(null, mensagem);
		new Jogo().start();
		
	}

	private  void start() {
		
		construirBaralho();
		jogadorA = new JogadorMaquina();
		jogadorA.setNome("Jogador virtual");
		jogadorB = new JogadorUsuario();
		jogadorB.setNome("Você");
		
//		imprimirBaralho(baralho.getCartas());
		
		boolean temVecendor = false;
		while(!temVecendor){
			construirBaralho();
			distribuirCartas();
			jogarMaoAtual();
			if(jogadorA.getPontos() == 12){
				temVecendor = true;
				JOptionPane.showMessageDialog(null,"O jogo acabou, "+jogadorA.getNome()+" venceu!");
			}
			if(jogadorB.getPontos() == 12){
				temVecendor = true;
				JOptionPane.showMessageDialog(null,"O jogo acabou, "+jogadorB.getNome()+" venceu!");
			}
			if(temVecendor){
				StringBuilder info = new StringBuilder("Placar do Jogo\n___________________\n"+jogadorA.getNome()+": "+jogadorA.getPontos()+" pontos\n "+jogadorB.getNome()+": "+jogadorB.getPontos()+" pontos");
				if(JOptionPane.showConfirmDialog(null, info.toString()+"\n\nJogo finalizado, deseja jogar novamnete?", "Fim de Jogo",JOptionPane.YES_NO_OPTION) == 0){
					start();
					
				}else{
					System.out.println("Jogo finalizado.");
					break;
				}
			}
			
		}
	}

	private void construirBaralho() {
		baralho = new Baralho();
		baralho.carregarBaralho();
		baralho.embaralhar();
	}

	private void jogarMaoAtual() {
		while (jogadorA.getCartas().size() > 0 && jogadorB.getCartas().size() > 0) {
			if (jogadorA.getUltimaJogaga() == null) {
				primeiraJogada();
				continue;
			}else{
				if (jogadorB.isVenceuMaoAtual()) {
					JOptionPane.showMessageDialog(null,jogadorB.getNome()+" matou, volta!");
					jogadorB.jogar();
					jogadorA.jogar();
					obterVencedorMaoAtual();
					if(verificaVencedorJogo()){
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null,jogadorA.getNome()+" matou e voltou!");
					jogadorA.jogar();
					jogadorB.jogar();
					obterVencedorMaoAtual();
					if(verificaVencedorJogo()){
						break;
					}
				}
			}
		}
		
	}

	private void primeiraJogada() {
		if(Math.random() > 0.5){
			jogadorB.jogar();
			jogadorA.jogar();
		}else{
			jogadorA.jogar();
			jogadorB.jogar();
		}
			
		obterVencedorMaoAtual();
		if(jogadorA.isVenceuMaoAtual())
			jogadorA.setVenceuPrimeiraMao(true);
		else
			jogadorB.setVenceuPrimeiraMao(true);
	}

	private void obterVencedorMaoAtual() {
		if(jogadorA.getUltimaJogaga().getValor() > jogadorB.getUltimaJogaga().getValor()){
			contA++;
			jogadorA.setVenceuMaoAtual(true);
			jogadorB.setVenceuMaoAtual(false);
		}else{
			contB++;
			jogadorB.setVenceuMaoAtual(true);
			jogadorA.setVenceuMaoAtual(false);
		}
	}

	private boolean verificaVencedorJogo() {
		boolean venceu =false;
		if (contA > 1) {
			JOptionPane.showMessageDialog(null, jogadorA.getNome()+" puxa 2 tentos.");
			jogadorA.setPontos((byte) (jogadorA.getPontos() + 2));
			venceu = true;
		} else if (contB > 1) {
			JOptionPane.showMessageDialog(null, jogadorB.getNome() + " puxa 2 tentos.");
			jogadorB.setPontos((byte) (jogadorB.getPontos() + 2));
			venceu = true;
		}
		return venceu;
	}


	private  void distribuirCartas() {
		jogadorA.getCartas().clear();
		jogadorB.getCartas().clear();
		jogadorA.setUltimaJogaga(null);
		jogadorB.setUltimaJogaga(null);
		contA = 0;
		contB = 0;
		distribuir(jogadorA);
		distribuir(jogadorB);
		
	}

	private void distribuir(Jogador jogador) {
		for(int i = 0; i < 3; i++){
			jogador.getCartas().add(baralho.getCartas().get(i));
			baralho.getCartas().remove(i);
		}
	}
	
//	private void imprimirBaralho(List<Carta> cartas) {
//		String s = "";
//		for(Carta c : cartas){
//			s += c.getNome().concat("\n");
//		} 
//		s.concat("=============================\n");
//	}
		
}
