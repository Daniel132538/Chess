package Ajedrez;

import java.util.ArrayList;

public abstract class Figura {
	private String nombreFigura;
	private int valor;	
	private int id;
	private Color color;
	
	
	public Figura(String nombreFigura, int valor, int id, Color color){
		this.nombreFigura = nombreFigura;
		this.valor = valor;
		this.id = id;
		this.color = color;
	}
	
	public enum Color {
		NEGRO, BLANCO
	}
	
	public abstract void Mover(Posicion posActual, Posicion PosicionNueva, Tablero tablero);
	
	public int Comer(Posicion posActual, Posicion PosicionNueva, Figura[][] tablero) {
		
		Figura figuraActual = tablero[posActual.getX()][posActual.getY()];
		Figura figuraNuevaPosicion = tablero[PosicionNueva.getX()][PosicionNueva.getY()];
		
		if (figuraNuevaPosicion == null) {
			return 0;
		} else if (figuraNuevaPosicion.getColor().equals(figuraActual.getColor())){
			return -1;
		} //else if (!figuraNuevaPosicion.getColor().equals(figuraActual.getColor())){
		else {
			return 1;
		}
	}
	
	public abstract ArrayList<Posicion> PosicionesPosiblesFigura(Figura[][] tablero);
	
	public ArrayList<Posicion> BuscarFigura(String nombre, Tablero tablero){
		Figura[][] figura = tablero.getTablero();
		ArrayList<Posicion> posicionesFigura = new ArrayList();
		
		for (int i=0; i < Tablero.SIZE_TABLERO; i++) {
			for (int j=0; j < Tablero.SIZE_TABLERO; j++) {
				if ((figura[i][j]).getNombreFigura().toString().equals(nombre)) {
					posicionesFigura.add(new Posicion(i, j));
				}
			}
		}
		
		return posicionesFigura;
	}

	public String getNombreFigura() {
		return nombreFigura;
	}

	public void setNombreFigura(String nombreFigura) {
		this.nombreFigura = nombreFigura;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
}
