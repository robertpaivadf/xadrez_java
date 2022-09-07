package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class UI {

	//COR DA FONTE
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_BLACK = "\u001B[33m";
	//COR DO FUNDO	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	
	
	public static void limparTela() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
	
	public static PosicaoXadrez lerPosicaoXadrez(Scanner sc) {
		try {
			String s = sc.nextLine();
			char coluna = s.charAt(0);
			int linha = Integer.parseInt(s.substring(1));
			return new PosicaoXadrez(coluna, linha);
		}
		catch(RuntimeException e) {
			throw new InputMismatchException("Erro ao ler a posição do xadrez, valores válidos de a1 até h8.");
		}
	}
	
	public static void mostrarPartida(PartidaXadrez partidaXadrez) {
		mostrarTabuleiro(partidaXadrez.getPecas());
		System.out.println();
		System.out.println();
		System.out.println("Turno: " + partidaXadrez.getTurno());
		System.out.println("Aguardando o jogador: " + partidaXadrez.getJogadorAtual());
	}
	
	
	public static void mostrarTabuleiro(PecaXadrez[][] pecas) {
		for(int i=0;i<pecas.length; i++) {
			System.out.print((8-i) + " ");
			for(int j=0;j<pecas.length; j++) {
				mostrarPeca(pecas[i][j], false);
			}
			System.out.println();
		}
		System.out.print("  a b c d e f g h");
	}
	
	public static void mostrarTabuleiro(PecaXadrez[][] pecas, boolean[][] movimentosPossiveis) {
		for(int i=0;i<pecas.length; i++) {
			System.out.print((8-i) + " ");
			for(int j=0;j<pecas.length; j++) {
				mostrarPeca(pecas[i][j], movimentosPossiveis[i][j]);
			}
			System.out.println();
		}
		System.out.print("  a b c d e f g h");
	}
	
	private static void mostrarPeca(PecaXadrez peca, boolean telaDeFundo) {
		if(telaDeFundo) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}		
		if(peca==null) {
			System.out.print("-" + ANSI_RESET);
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


