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
		NEGRO , BLANCO 
	}

	public void Mover(Posicion posActual, Posicion PosicionNueva, Tablero tablero) {
		// TODO Auto-generated method stub
		ArrayList<Posicion> posicionesPosibles = PosicionesPosiblesFigura(tablero.getTablero(), posActual);
		if (PosicionNueva.contienePosicion(posicionesPosibles)) {
			boolean haComido = this.Comer(posActual, PosicionNueva, tablero.getTablero());
			Figura figuraComida = null;
			if (haComido) {
	            // Guardar la figura que ha sido comida
	            figuraComida = tablero.obtenerFigura(PosicionNueva);
	        }
			tablero.colocarFigura(this, PosicionNueva);
			tablero.colocarFigura(null, posActual);
			
			// Mostrar el resultado del movimiento
	        if (haComido) {
	            System.out.println("El " + this.getNombreFigura() + " ha comido al " + figuraComida.getNombreFigura() + " en la posición " + PosicionNueva.descripcion() + ".");
	        } else {
	            System.out.println("El " + this.getNombreFigura() + " se ha movido a la posición" + PosicionNueva.descripcion() + ".");
	        }
		} else {
			System.out.print("No se puede mover a la posición indicada. Las posiciones posibles para "
					+  this.getNombreFigura() + "son:");
			if (posicionesPosibles.size() > 0) {
				for (Posicion posicion: posicionesPosibles) {
					System.out.println("(" + posicion.getX() + "," + posicion.getY() + ")");
				}
			} else System.out.println("La figura escogida no puede ser movida en está posición");
		}
	}
	
	public abstract ArrayList<Posicion> PosicionesPosiblesFigura(Figura[][] tablero, Posicion pos);
	
	public boolean Comer(Posicion posActual, Posicion PosicionNueva, Figura[][] tablero) {
		
		Figura figuraActual = tablero[posActual.getX()][posActual.getY()];
		Figura figuraNuevaPosicion = tablero[PosicionNueva.getX()][PosicionNueva.getY()];
		
		if (figuraNuevaPosicion != null && !figuraNuevaPosicion.getColor().equals(figuraActual.getColor())){
			return true;
		} else {
			return false;
		}
	}
	
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
