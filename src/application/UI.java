package application;

import xadrez.Cor;
import xadrez.PecaXadrez;

public class UI {

	//COR DA FONTE
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_BLACK = "\u001B[33m";
	//COR DO FUNDO	
	public static final String ANSI_RESET = "\u001B[0m";
	
	
	public static void mostrarTabuleiro(PecaXadrez[][] pecas) {
		for(int i=0;i<pecas.length; i++) {
			System.out.print((8-i) + " ");
			for(int j=0;j<pecas.length; j++) {
				mostrarPeca(pecas[i][j]);
			}
			System.out.println();
		}
		System.out.print("  a b c d e f g h");
	}
	
	private static void mostrarPeca(PecaXadrez peca) {
		if(peca==null) {
			System.out.print("-");
		}
		else {
			if(peca.getCor() == Cor.BRANCO) {
				System.out.print(ANSI_WHITE + peca + ANSI_RESET);
			}
			else {
				System.out.print(ANSI_BLACK + peca + ANSI_RESET);
			}
				
		}
		System.out.print(" ");
	}
	
}


