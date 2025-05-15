package controlador;

import modelo.Jugador;
import java.util.*;

public class gestorJugador {
    private List<Jugador> jugadores = new ArrayList<>();

    public void addJugador(Jugador j) {
        jugadores.add(j);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public Optional<Jugador> getJugadorPorNombre(String nombre) {
        return jugadores.stream()
                        .filter(j -> j.getNombre().equalsIgnoreCase(nombre))
                        .findFirst();
    }

    public void reset() {
        jugadores.clear();
    }
}
