package Ajedrez;

import java.util.ArrayList;

public class Alfil extends Figura{
	public Alfil(Color color) {
		super("Alfil", 3, 4, color);
	}

	@Override
	public ArrayList<Posicion> PosicionesPosiblesFigura(Figura[][] tablero, Posicion pos) {
        ArrayList<Posicion> posicionesPosibles = new ArrayList<>();

        // Movimientos diagonales hacia arriba y hacia la izquierda
        for (int i = 1; pos.getX() - i >= 0 && pos.getY() - i >= 0; i++) {
            if (tablero[pos.getX() - i][pos.getY() - i] == null) {
                posicionesPosibles.add(new Posicion(pos.getX() - i, pos.getY() - i));
            } else {
                if (tablero[pos.getX() - i][pos.getY() - i].getColor() != this.getColor()) {
                    posicionesPosibles.add(new Posicion(pos.getX() - i, pos.getY() - i));
                }
                break;
            }
        }

        // Movimientos diagonales hacia arriba y hacia la derecha
        for (int i = 1; pos.getX() - i >= 0 && pos.getY() + i < 8; i++) {
            if (tablero[pos.getX() - i][pos.getY() + i] == null) {
                posicionesPosibles.add(new Posicion(pos.getX() - i, pos.getY() + i));
            } else {
                if (tablero[pos.getX() - i][pos.getY() + i].getColor() != this.getColor()) {
                    posicionesPosibles.add(new Posicion(pos.getX() - i, pos.getY() + i));
                }
                break;
            }
        }

        // Movimientos diagonales hacia abajo y hacia la izquierda
        for (int i = 1; pos.getX() + i < 8 && pos.getY() - i >= 0; i++) {
            if (tablero[pos.getX() + i][pos.getY() - i] == null) {
                posicionesPosibles.add(new Posicion(pos.getX() + i, pos.getY() - i));
            } else {
                if (tablero[pos.getX() + i][pos.getY() - i].getColor() != this.getColor()) {
                    posicionesPosibles.add(new Posicion(pos.getX() + i, pos.getY() - i));
                }
                break;
            }
        }

        // Movimientos diagonales hacia abajo y hacia la derecha
        for (int i = 1; pos.getX() + i < 8 && pos.getY() + i < 8; i++) {
            if (tablero[pos.getX() + i][pos.getY() + i] == null) {
                posicionesPosibles.add(new Posicion(pos.getX() + i, pos.getY() + i));
            } else {
                if (tablero[pos.getX() + i][pos.getY() + i].getColor() != this.getColor()) {
                    posicionesPosibles.add(new Posicion(pos.getX() + i, pos.getY() + i));
                }
                break;
            }
        }

        return posicionesPosibles;
    }
	
	
}
