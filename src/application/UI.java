package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
	
	public static void mostrarPartida(PartidaXadrez partidaXadrez, List<PecaXadrez> capturadas) {
		mostrarTabuleiro(partidaXadrez.getPecas());
		System.out.println();
		mostrarPecasCapturadas(capturadas);
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
	
	private static void mostrarPecasCapturadas(List<PecaXadrez> capturadas) {
		List<PecaXadrez> brancas = capturadas.stream().filter(x -> x.getCor() == Cor.BRANCO).collect(Collectors.toList());
		List<PecaXadrez> pretas = capturadas.stream().filter(x -> x.getCor() == Cor.PRETO).collect(Collectors.toList());
		System.out.println();
		System.out.println("Peças Capturadas:");
		System.out.print("Brancas: ");
		System.out.print(ANSI_WHITE);
		System.out.print(Arrays.toString(brancas.toArray()));
		System.out.print(ANSI_RESET);
		System.out.println();
		
		System.out.print("Pretas: ");
		System.out.print(ANSI_BLACK);
		System.out.print(Arrays.toString(pretas.toArray()));
		System.out.print(ANSI_RESET);
	}
	
	
}


