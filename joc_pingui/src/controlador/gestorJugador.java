package controlador;

import modelo.Jugador;
import java.util.Scanner;

/**
 * Controlador de interacción por consola (si lo quisieras usar).
 */
public class gestorJugador {
    private Jugador jugador;

    public gestorJugador(Jugador j) {
        this.jugador = j;
    }

    public void configurarDesdeConsola() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        jugador.setNombre(sc.nextLine());
        System.out.print("Color: ");
        jugador.setColor(sc.nextLine());
    }
}
