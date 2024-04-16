package Ajedrez;

import java.util.ArrayList;

public class Torre extends Figura{
	public Torre(Color color) {
		super("Torre", 5, 2, color);
	}

	@Override
	public void Mover(Posicion posActual, Posicion PosicionNueva, Tablero tablero) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<Posicion> PosicionesPosiblesFigura(Figura[][] tablero, Posicion pos) {
        ArrayList<Posicion> posicionesPosibles = new ArrayList<>();

        // Movimientos horizontales
        for (int i = pos.getX() - 1; i >= 0; i--) {
            if (tablero[i][pos.getY()] == null) {
                posicionesPosibles.add(new Posicion(i, pos.getY()));
            } else {
                if (tablero[i][pos.getY()].getColor() != this.getColor()) {
                    posicionesPosibles.add(new Posicion(i, pos.getY()));
                }
                break;
            }
        }
        for (int i = pos.getX() + 1; i < 8; i++) {
            if (tablero[i][pos.getY()] == null) {
                posicionesPosibles.add(new Posicion(i, pos.getY()));
            } else {
                if (tablero[i][pos.getY()].getColor() != this.getColor()) {
                    posicionesPosibles.add(new Posicion(i, pos.getY()));
                }
                break;
            }
        }

        // Movimientos verticales
        for (int i = pos.getY() - 1; i >= 0; i--) {
            if (tablero[pos.getX()][i] == null) {
                posicionesPosibles.add(new Posicion(pos.getX(), i));
            } else {
                if (tablero[pos.getX()][i].getColor() != this.getColor()) {
                    posicionesPosibles.add(new Posicion(pos.getX(), i));
                }
                break;
            }
        }
        for (int i = pos.getY() + 1; i < 8; i++) {
            if (tablero[pos.getX()][i] == null) {
                posicionesPosibles.add(new Posicion(pos.getX(), i));
            } else {
                if (tablero[pos.getX()][i].getColor() != this.getColor()) {
                    posicionesPosibles.add(new Posicion(pos.getX(), i));
                }
                break;
            }
        }

        return posicionesPosibles;
    }
}
