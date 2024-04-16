package Ajedrez;

import Ajedrez.Figura.Color;
import java.util.*;

public class Tablero implements Cloneable {
	private Figura[][] tablero;
	public static final int SIZE_FILAS = 8;
	public static final int SIZE_COLUMNAS = 8;
	public static final int SIZE_TABLERO = 8;
	
	public Tablero(){
		tablero = new Figura[SIZE_FILAS][SIZE_COLUMNAS];
	}
	
	public void comenzarPartida(){
		tablero[0][0] = new Torre(Color.BLANCO);
		tablero[1][0] = new Caballo(Color.BLANCO);
		tablero[2][0] = new Alfil(Color.BLANCO);
		tablero[3][0] = new Reina(Color.BLANCO);
		tablero[4][0] = new Rey(Color.BLANCO);
		tablero[5][0] = new Alfil(Color.BLANCO);
		tablero[6][0] = new Caballo(Color.BLANCO);
		tablero[7][0] = new Torre(Color.BLANCO);
		
		for (int i = 0; i <8; i++) {
			tablero[i][1] = new Peon(Color.BLANCO);
		}
		
		tablero[0][SIZE_FILAS-1] = new Torre(Color.NEGRO);
		tablero[1][SIZE_FILAS-1] = new Caballo(Color.NEGRO);
		tablero[2][SIZE_FILAS-1] = new Alfil(Color.NEGRO);
		tablero[3][SIZE_FILAS-1] = new Reina(Color.NEGRO);
		tablero[4][SIZE_FILAS-1] = new Rey(Color.NEGRO);
		tablero[5][SIZE_FILAS-1] = new Alfil(Color.NEGRO);
		tablero[6][SIZE_FILAS-1] = new Caballo(Color.NEGRO);		
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
	public boolean moverPieza(Posicion posActual , Posicion posFinal) {
		return tablero[posActual.getX()][posActual.getY()].Mover(posActual, posFinal, this);
	}
	
	public Posicion obtenerPosicionRey(Color colorRey){
		for (int i = 0; i < SIZE_FILAS; i++) {
			for (int j = 0; j < SIZE_FILAS; j++) {
				if (tablero[i][j] != null && tablero[i][j].getNombreFigura().equals("Rey") && tablero[i][j].getColor().equals(colorRey)) return new Posicion(i, j);
			}
		}
		return null;
	}
	
	public ArrayList<PosicionFigura> obtenerPiezasOponente(Color color){
		ArrayList<PosicionFigura> figuras= new ArrayList<>();
		for (int i = 0; i < SIZE_FILAS; i++) {
			for (int j = 0; j < SIZE_FILAS; j++) {
				if (tablero[i][j] != null && !tablero[i][j].getColor().equals(color)) {
					figuras.add(new PosicionFigura(new Posicion(i,j), tablero[i][j]));
				}
			}
		}
		return figuras;
	}
	
	public ArrayList<PosicionFigura> obtenerPiezasJugador(Color color){
		ArrayList<PosicionFigura> figuras= new ArrayList<>();
		for (int i = 0; i < SIZE_FILAS; i++) {
			for (int j = 0; j < SIZE_FILAS; j++) {
				if (tablero[i][j] != null && tablero[i][j].getColor().equals(color)) {
					figuras.add(new PosicionFigura(new Posicion(i,j), tablero[i][j]));
				}
			}
		}
		return figuras;
	}
	
	public boolean comprobarJaque(Color colorRey, Tablero tablero) {
        // Obtener la posición del rey del color especificado
        Posicion posicionRey = this.obtenerPosicionRey(colorRey);

        // Verificar si alguna pieza del oponente amenaza la posición del rey
        for (PosicionFigura figura : this.obtenerPiezasOponente(colorRey)) {
            ArrayList<Posicion> posicionesPosibles = figura.getFigura().PosicionesPosiblesFigura(tablero.getTablero(), figura.getPosicion());
            if (posicionesPosibles.contains(posicionRey)) {
                return true;
            }
        }
        return false;
    }

    public boolean comprobarJaqueMate(Color colorJugador) throws CloneNotSupportedException {
        if (!comprobarJaque(colorJugador, this)) {
            return false; // No hay jaque, no hay jaque mate
        }

        // Verificar si el jugador puede hacer algún movimiento para salir del jaque
        for (PosicionFigura figura : this.obtenerPiezasJugador(colorJugador)) {
            Posicion posicionActual = figura.getPosicion();
            ArrayList<Posicion> posicionesPosibles = figura.getFigura().PosicionesPosiblesFigura(this.getTablero(), posicionActual);
            for (Posicion posicionNueva : posicionesPosibles) {
                Tablero tableroCopia = this.clone(); // Copiar el tablero para simular el movimiento
                tableroCopia.moverPieza(figura.getPosicion(), posicionNueva); // Simular el movimiento
                if (!comprobarJaque(colorJugador, tableroCopia)) {
                    return false; // Hay al menos un movimiento que evita el jaque mate
                }
            }
        }

        return true; // No hay movimientos legales que eviten el jaque mate
    }
    
    @Override
    public Tablero clone() throws CloneNotSupportedException {
        Tablero nuevoTablero = (Tablero) super.clone();
        // Aquí debes clonar cualquier otro objeto mutable presente en la clase Tablero si es necesario
        return nuevoTablero;
    }

	
}
