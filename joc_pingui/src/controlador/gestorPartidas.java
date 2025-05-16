package controlador;

import modelo.Jugador;
import modelo.Tablero;
import vista.bbdd;

import java.util.List;

public class gestorPartidas {

    /**
     * Guarda una partida en la base de datos.
     *
     * @param id        Identificador de la partida
     * @param jugadores Lista de jugadores con su estado actual
     * @param tablero   Estado completo del tablero
     */
    public void guardar(int id, List<Jugador> jugadores, Tablero tablero) {
        // Convertimos la lista en array, que es lo que espera bbdd.guardarPartida
        Jugador[] arrJugadores = jugadores.toArray(new Jugador[0]);

        // Llamamos al método estático que implementa el JDBC/Oracle
        bbdd.guardarPartida(id, arrJugadores, tablero);
    }

    /**
     * Carga una partida de la base de datos.
     *
     * @param id ID de la partida a cargar
     * @return   El objeto Partida (con Jugadores y Tablero) o null si no existe
     */
    public vista.bbdd.Partida cargar(int id) {
        return bbdd.cargarPartida(id);
    }
}