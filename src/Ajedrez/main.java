package Ajedrez;

import java.util.Scanner;

import Ajedrez.Figura.Color;

public class main {
	public static void main(String args[]) {
		Tablero tablero = new Tablero();
		tablero.comenzarPartida();
		Scanner scanner = new Scanner(System.in);
		
		boolean juegoActivo = true;
	    Color turnoActual = Color.BLANCO; // Comienzan las blancas
	    while (juegoActivo) {
	        //tablero.mostrarTablero();
	        System.out.println("Turno de las " + (turnoActual == Color.BLANCO ? "blancas" : "negras"));

	        boolean movimientoValido = false;
	        while (!movimientoValido) {
	            // Obtener la posición de la figura que el jugador desea mover
	            System.out.println("¿Qué figura desea mover? Introduzca las coordenadas x e y: ");
	            int xOrigen = scanner.nextInt();
	            int yOrigen = scanner.nextInt();
	            Posicion posicionOrigen = new Posicion(xOrigen, yOrigen);
	            Figura figuraElegida = tablero.obtenerFigura(posicionOrigen);

	            if (figuraElegida != null && figuraElegida.getColor() == turnoActual) {
	                System.out.println("Ha elegido el " + figuraElegida.getNombreFigura() + " en la posición (" + xOrigen + "," + yOrigen + ").");
	                System.out.println("¿A qué posición desea mover la pieza? Introduzca las coordenadas x e y: ");
	                int xDestino = scanner.nextInt();
	                int yDestino = scanner.nextInt();
	                Posicion posicionDestino = new Posicion(xDestino, yDestino);

	                // Intentar mover la figura a la nueva posición
	                if (tablero.moverPieza(posicionOrigen, posicionDestino)) {
	                    movimientoValido = true;
	                } else {
	                    System.out.println("Movimiento inválido. Intente de nuevo.");
	                }
	            } else {
	                System.out.println("No hay ninguna figura válida en la posición especificada.");
	            }
	        }

	        // Cambiar el turno al jugador opuesto
	        turnoActual = (turnoActual == Color.BLANCO) ? Color.NEGRO : Color.BLANCO;

	        // Verificar si el juego ha terminado
	        try {
				if (tablero.comprobarJaqueMate(turnoActual)) {
				    System.out.println("¡Jaque mate! Las " + (turnoActual == Color.BLANCO ? "blancas" : "negras") + " han ganado.");
				    juegoActivo = false;
				}
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // Verificar si el jugador desea continuar jugando
	        System.out.print("¿Desea continuar jugando? (s/n): ");
	        String continuar = scanner.next();
	        juegoActivo = continuar.equalsIgnoreCase("s");
	    }

        scanner.close();
		
	}
}
