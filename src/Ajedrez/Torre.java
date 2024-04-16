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
	public ArrayList<Posicion> PosicionesPosiblesFigura(Figura[][] tablero) {
		// TODO Auto-generated method stub
		return null;
	}
}
