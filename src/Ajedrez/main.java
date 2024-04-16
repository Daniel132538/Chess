package Ajedrez;

import java.util.Scanner;

public class main {
	public static void main(String args[]) {
		Tablero tablero = new Tablero();
		tablero.comenzarPartida();
		Scanner scanner = new Scanner(System.in);
		
		boolean juegoActivo = true;
        while (juegoActivo) {
            // Obtener la posición de la figura que el jugador desea mover
            System.out.println("¿Qué figura desea mover? Introduzca las coordenadas x e y: ");
            int xOrigen = scanner.nextInt();
            int yOrigen = scanner.nextInt();
            Posicion posicionOrigen = new Posicion(xOrigen, yOrigen);
            Figura figuraElegida = tablero.obtenerFigura(posicionOrigen);

            if (figuraElegida != null) {
                System.out.println("Ha elegido el " + figuraElegida.getNombreFigura() + " en la posición (" + xOrigen + "," + yOrigen + ").");
                System.out.println("¿A qué posición desea mover la pieza? Introduzca las coordenadas x e y: ");
                int xDestino = scanner.nextInt();
                int yDestino = scanner.nextInt();
                Posicion posicionDestino = new Posicion(xDestino, yDestino);

                // Intentar mover la figura a la nueva posición
                tablero.moverPieza(posicionOrigen, posicionDestino);
            } else {
                System.out.println("No hay ninguna figura en la posición especificada.");
            }

            // Verificar si el jugador desea continuar jugando
            /*System.out.print("¿Desea continuar jugando? (s/n): ");
            String continuar = scanner.next();
            juegoActivo = continuar.equalsIgnoreCase("s");*/
        }

        scanner.close();
		
	}
}
