package Ajedrez;

import Ajedrez.Figura.Color;

public class Tablero {
	private Figura[][] tablero;
	public static final int SIZE_TABLERO = 8;
	
	public Tablero(){
		tablero = new Figura[SIZE_TABLERO][SIZE_TABLERO];
	}
	
	public void comenzarPartida(){
		tablero[0][0] = new Torre(Color.BLANCO);
		tablero[0][1] = new Alfil(Color.BLANCO);
		tablero[0][2] = new Caballo(Color.BLANCO);
		tablero[0][3] = new Reina(Color.BLANCO);
		tablero[0][4] = new Rey(Color.BLANCO);
		tablero[0][5] = new Caballo(Color.BLANCO);
		tablero[0][6] = new Alfil(Color.BLANCO);
		tablero[0][7] = new Torre(Color.BLANCO);
		
		for (int i = 0; i <8; i++) {
			tablero[1][i] = new Peon(Color.BLANCO);
		}
		
		tablero[SIZE_TABLERO-1][0] = new Torre(Color.NEGRO);
		tablero[SIZE_TABLERO-1][1] = new Alfil(Color.NEGRO);
		tablero[SIZE_TABLERO-1][2] = new Caballo(Color.NEGRO);
		tablero[SIZE_TABLERO-1][3] = new Reina(Color.NEGRO);
		tablero[SIZE_TABLERO-1][4] = new Rey(Color.NEGRO);
		tablero[SIZE_TABLERO-1][5] = new Caballo(Color.NEGRO);
		tablero[SIZE_TABLERO-1][6] = new Alfil(Color.NEGRO);
		tablero[SIZE_TABLERO-1][7] = new Torre(Color.NEGRO);
		
		for (int i = 0; i <8; i++) {
			tablero[SIZE_TABLERO-2][i] = new Peon(Color.NEGRO);
		}
	}

	public Figura[][] getTablero() {
		return tablero;
	}

	public void setTablero(Figura[][] tablero) {
		this.tablero = tablero;
	}
	
	
}
