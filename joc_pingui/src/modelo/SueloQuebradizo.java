package modelo;

import controlador.gestorPartidas;
import java.util.List;

/**
 * Casilla que hace retroceder al jugador una posición (o al inicio).
 */
public class SueloQuebradizo extends Casilla {

    public SueloQuebradizo(int posicion, List<Jugador> ocupantes) {
        super(posicion, ocupantes);
    }

    @Override
    public void realizarAccion(Jugador j, gestorPartidas gp) {
        // Posición actual de la casilla
        int actual = getPosicion();
        // Calculamos la casilla anterior (o 0 si estamos en la 0)
        int anterior = actual > 0 ? actual - 1 : 0;

        // 1) Quitamos al jugador de la casilla actual
        gp.getTablero().getCasillas().get(actual).quitarJugador(j);

        // 2) Actualizamos su posición interna
        j.setPosicion(anterior);

        // 3) Añadimos al jugador en la casilla anterior
        gp.getTablero().getCasillas().get(anterior).añadirJugador(j);
    }
}
