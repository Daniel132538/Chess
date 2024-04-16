package Ajedrez;

import java.util.ArrayList;

public class Peon extends Figura{
	public Peon(Color color){
		super("Peon", 1, 5, color);
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
