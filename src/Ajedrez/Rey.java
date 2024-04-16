package Ajedrez;

import java.util.ArrayList;

public class Rey extends Figura{
	public Rey(Color color){
		super("Rey", 0, 0, color);
	}

	@Override
	public void Mover(Posicion posActual, Posicion PosicionNueva, Tablero tablero) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
    public ArrayList<Posicion> PosicionesPosiblesFigura(Figura[][] tablero, Posicion pos) {
        ArrayList<Posicion> posicionesPosibles = new ArrayList<>();

        // Movimientos horizontales
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) { // No incluir la casilla actual
                    int newX = pos.getX() + i;
                    int newY = pos.getY() + j;
                    if (esValida(newX, newY) && (tablero[newX][newY] == null || tablero[newX][newY].getColor() != this.getColor())) {
                        posicionesPosibles.add(new Posicion(newX, newY));
                    }
                }
            }
        }

        return posicionesPosibles;
    }

    // Método auxiliar para verificar si una posición está dentro del tablero
    private boolean esValida(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
