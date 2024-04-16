package Ajedrez;

import java.util.ArrayList;

import Ajedrez.Figura.Color;

public class Peon extends Figura{
	public Peon(Color color){
		super("Peon", 1, 5, color);
	}

	@Override
	public void Mover(Posicion posActual, Posicion PosicionNueva, Tablero tablero) {
		// TODO Auto-generated method stub
		ArrayList<Posicion> posicionesPosibles = PosicionesPosiblesFigura(tablero.getTablero(), posActual);
		//boolean esMovimientoValido = posicionesPosibles.contains(PosicionNueva);
		if (PosicionNueva.contienePosicion(posicionesPosibles)) {
			boolean haComido = this.Comer(posActual, PosicionNueva, tablero.getTablero());
			Figura figuraComida = null;
			if (haComido) {
	            // Guardar la figura que ha sido comida
	            figuraComida = tablero.obtenerFigura(PosicionNueva);
	        }
			
			tablero.colocarFigura(this, PosicionNueva);
			// Verificar si el peón ha alcanzado el borde del tablero
	        if ((PosicionNueva.getY() == 0 && this.getColor() == Color.NEGRO) || 
	            (PosicionNueva.getY() == Tablero.SIZE_FILAS - 1 && this.getColor() == Color.BLANCO)) {
	            // Promover el peón
	            // Aquí puedes implementar la lógica para la promoción del peón
	            // Por ejemplo, puedes pedir al jugador que elija a qué pieza desea promover el peón
	            // Luego, puedes crear la nueva pieza (reina, torre, alfil o caballo) y colocarla en la posición nueva
	            // Aquí asumimos que la promoción es a una reina por simplicidad
	            tablero.colocarFigura(new Reina(this.getColor()), PosicionNueva);
	            System.out.print("El peón ha coronado");
	        }
	        tablero.colocarFigura(null, posActual);
	        // Mostrar el resultado del movimiento
	        if (haComido) {
	            System.out.println("El " + this.getNombreFigura() + " ha comido al " + figuraComida.getNombreFigura() + " en la posición " + PosicionNueva.descripcion() + ".");
	        } else {
	            System.out.println("El " + this.getNombreFigura() + " se ha movido a " + PosicionNueva.descripcion() + ".");
	        }
		} else {
			System.out.println("No se puede mover a la posición indicada. Las posiciones posibles para "
					+  this.getNombreFigura() + " son:");
			if (posicionesPosibles.size() > 0) {
				for (Posicion posicion: posicionesPosibles) {
					System.out.println("(" + posicion.getX() + "," + posicion.getY() + ")");
				}
			} else System.out.println("La figura escogida no puede ser movida en está posición");
		}
	}

	@Override
	public ArrayList<Posicion> PosicionesPosiblesFigura(Figura[][] tablero, Posicion pos) {
        ArrayList<Posicion> posiblesPosiciones = new ArrayList<>();
        int direccionMovimiento = (this.getColor() == Color.BLANCO) ? 1 : -1;

        // Movimiento hacia adelante
        if (tablero[pos.getX()][pos.getY() + direccionMovimiento] == null) {
            posiblesPosiciones.add(new Posicion(pos.getX(), pos.getY() + direccionMovimiento));
            
            // Movimiento doble en el primer movimiento
            if ((this.getColor() == Color.BLANCO && pos.getY() == 1) || (this.getColor() == Color.NEGRO && pos.getY() == 6)) {
                if (tablero[pos.getX()][pos.getY() + 2 * direccionMovimiento] == null) {
                    posiblesPosiciones.add(new Posicion(pos.getX(), pos.getY() + 2 * direccionMovimiento));
                }
            }
        }

        // Movimiento diagonal para capturar
        if (pos.getX() > 0 && tablero[pos.getX() - 1][pos.getY() + direccionMovimiento] != null &&
            tablero[pos.getX() - 1][pos.getY() + direccionMovimiento].getColor() != this.getColor()) {
            posiblesPosiciones.add(new Posicion(pos.getX() - 1, pos.getY() + direccionMovimiento));
        }
        if (pos.getX() < 7 && tablero[pos.getX() + 1][pos.getY() + direccionMovimiento] != null &&
            tablero[pos.getX() + 1][pos.getY() + direccionMovimiento].getColor() != this.getColor()) {
            posiblesPosiciones.add(new Posicion(pos.getX() + 1, pos.getY() + direccionMovimiento));
        }

        return posiblesPosiciones;
    }
}
