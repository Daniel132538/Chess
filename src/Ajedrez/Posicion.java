package Ajedrez;

import java.util.ArrayList;

public class Posicion {
	private int x;
	private int y;
	
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean igual(Posicion posicion) {
		if (posicion.getX() == this.getX() && posicion.getY() == this.getY()){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contienePosicion(ArrayList<Posicion> posiciones) {
		for (Posicion posicion: posiciones) {
			if (this.igual(posicion)) {
				return true;
			}
		}
		return false;
	}
	
	public String descripcion() {
		return "Posición (" + this.getX() + "," + this.getY() + ")";
	}
	
}
