package Ajedrez;

import java.util.ArrayList;

public class Reina extends Figura{
	private Alfil alfil;
	private Torre torre;
	public Reina(Color color) {
		super("Reina", 9, 1, color);
		this.alfil = new Alfil(color);
		this.torre = new Torre(color);
	}

	@Override
	public ArrayList<Posicion> PosicionesPosiblesFigura(Figura[][] tablero, Posicion pos) {
		// TODO Auto-generated method stub
		ArrayList<Posicion> posicionesPosibles = new ArrayList<>();
		
		posicionesPosibles.addAll(alfil.PosicionesPosiblesFigura(tablero, pos));
		posicionesPosibles.addAll(torre.PosicionesPosiblesFigura(tablero, pos));

		return posicionesPosibles;
	}
}
