package xadrez;

import tabuleiro.TabException;

public class XadrezException  extends TabException{
	private static final long serialVersionUID = 1L;
	
	public XadrezException( String msg) {
		super(msg);
	}

}
