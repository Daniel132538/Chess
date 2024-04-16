package Ajedrez;

import Ajedrez.Figura.Color;

public class Tablero {
	private Figura[][] tablero;
	public static final int SIZE_FILAS = 8;
	public static final int SIZE_COLUMNAS = 8;
	public static final int SIZE_TABLERO = 8;
	
	public Tablero(){
		tablero = new Figura[SIZE_FILAS][SIZE_COLUMNAS];
	}
	
	public void comenzarPartida(){
		tablero[0][0] = new Torre(Color.BLANCO);
		tablero[1][0] = new Alfil(Color.BLANCO);
		tablero[2][0] = new Caballo(Color.BLANCO);
		tablero[3][0] = new Reina(Color.BLANCO);
		tablero[4][0] = new Rey(Color.BLANCO);
		tablero[5][0] = new Caballo(Color.BLANCO);
		tablero[6][0] = new Alfil(Color.BLANCO);
		tablero[7][0] = new Torre(Color.BLANCO);
		
		for (int i = 0; i <8; i++) {
			tablero[i][1] = new Peon(Color.BLANCO);
		}
		
		tablero[0][SIZE_FILAS-1] = new Torre(Color.NEGRO);
		tablero[1][SIZE_FILAS-1] = new Alfil(Color.NEGRO);
		tablero[2][SIZE_FILAS-1] = new Caballo(Color.NEGRO);
		tablero[3][SIZE_FILAS-1] = new Reina(Color.NEGRO);
		tablero[4][SIZE_FILAS-1] = new Rey(Color.NEGRO);
		tablero[5][SIZE_FILAS-1] = new Caballo(Color.NEGRO);
		tablero[6][SIZE_FILAS-1] = new Alfil(Color.NEGRO);
		tablero[7][SIZE_FILAS-1] = new Torre(Color.NEGRO);
		
		for (int i = 0; i <8; i++) {
			tablero[i][SIZE_FILAS-2] = new Peon(Color.NEGRO);
		}
	}

	public Figura[][] getTablero() {
		return tablero;
	}

	public void setTablero(Figura[][] tablero) {
		this.tablero = tablero;
	}
	
	public Figura obtenerFigura(Posicion pos) {
		return tablero[pos.getX()][pos.getY()];
	}
	
	public void colocarFigura(Figura figura, Posicion pos){
		tablero[pos.getX()][pos.getY()] = figura;
	}
	public void moverPieza(Posicion posActual , Posicion posFinal) {
		tablero[posActual.getX()][posActual.getY()].Mover(posActual, posFinal, this);
	}
	
}
