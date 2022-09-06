package xadrez;

import tabuleiro.Posicao;

public class PosicaoXadrez {

	private char coluna;
	private int linha;
	
	public PosicaoXadrez(char coluna, int linha) {
		if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrezException("Posi��o incorreta, valores v�lidos de a1 at� h8.");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	private char getColuna() {
		return coluna;
	}

	private int getLinha() {
		return linha;
	}

	protected Posicao paraPosicao() {
		return new Posicao(8 - linha, coluna - 'a');
	}
	
	protected static PosicaoXadrez daPosicao(Posicao position){
		return new PosicaoXadrez((char)('a' - position.getColuna()), 8 - position.getLinha());
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
	
	
}
