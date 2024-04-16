package Ajedrez;

import java.util.ArrayList;

import Ajedrez.Figura.Color;




public class Caballo extends Figura{

	public Caballo(Color color) {
		super("Caballo", 3, 3, color);
	}

	@Override
	public ArrayList<Posicion> PosicionesPosiblesFigura(Figura[][] tablero, Posicion pos) {
		// TODO Auto-generated method stub
		ArrayList<Posicion> posicionesPosibles = new ArrayList<>();
		// Movimientos posibles del caballo (8 en total)
        int[][] movimientos = {
                {2, 1}, {1, 2},
                {-2, 1}, {-1, 2},
                {-2, -1}, {-1, -2},
                {2, -1}, {1, -2}
        };
        
        // Verificar cada uno de los movimientos posibles
        for (int[] movimiento : movimientos) {
            int newX = pos.getX() + movimiento[0];
            int newY = pos.getY() + movimiento[1];

            // Verificar si la nueva posición está dentro del tablero
            if (esValida(newX, newY)) {
                posicionesPosibles.add(new Posicion(newX, newY));
            }
        }
		
		return posicionesPosibles;
	}
	
	
	 private boolean esValida(int x, int y) {
		 return x >= 0 && x < 8 && y >= 0 && y < 8;
	 }

}
