package application;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaXadrez;

public class Program {

	public static void main(String[] args) {
		
		PartidaXadrez  partidaXadrez = new PartidaXadrez();
		
		UI.mostrarTabuleiro(partidaXadrez.getPecas());
	}

}
