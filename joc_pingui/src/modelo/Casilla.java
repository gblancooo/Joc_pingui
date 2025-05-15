package modelo;
import controlador.gestorPartidas;
import java.util.*;

public abstract class Casilla {
    private final int posicion;
    private final List<Jugador> jugadoresActuales;

    public Casilla(int posicion) {
        this.posicion = posicion;
        this.jugadoresActuales = new ArrayList<>();
    }

    public Casilla(int posicion, List<Jugador> jugadoresActuales) {
        this.posicion = posicion;
        this.jugadoresActuales = jugadoresActuales;
    }

    public abstract void realizarAccion(Jugador j, gestorPartidas gp);

    public int getPosicion() {
        return posicion;
    }

    public List<Jugador> getJugadoresActuales() {
        return jugadoresActuales;
    }

    public void añadirJugador(Jugador j) {
        jugadoresActuales.add(j);
    }

    public void quitarJugador(Jugador j) {
        jugadoresActuales.remove(j);
    }
}
