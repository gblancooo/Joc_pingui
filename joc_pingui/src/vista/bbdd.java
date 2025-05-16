package vista;

import modelo.*;
import modelo.Casilla;
import modelo.CasillaNormal;
import modelo.Agujero;
import modelo.Oso;
import modelo.Trineo;
import modelo.Interrogant;
import modelo.SueloQuebradizo;

import java.sql.*;
import java.util.*;
import java.lang.reflect.Field;

public class bbdd {

	
    private static final String URL  = "jdbc:oracle:thin:@oracle.ilerna.com:1521/XEPDB2";
    private static final String USER = "DM2425_PIN_GRUP05";
    private static final String PASS = "ABGLT05";

    private static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    /**
     * Guarda una partida completa en la BBDD.
     *
     * @param id        Identificador de la partida (debe existir secuencia/trigger)
     * @param jugadores Array de jugadores con su estado (posición, inventario...)
     * @param tablero   Tablero con la lista de casillas a persistir
     */
    public static void guardarPartida(int id, Jugador[] jugadores, Tablero tablero) {
        String sqlPartida = "INSERT INTO Partida(id_partida, turno_actual) VALUES (?, ?)";
        String sqlJugador = 
            "INSERT INTO JugadorPartida(id_partida, nombre, color, posicion, turnos_perdidos) " +
            "VALUES (?, ?, ?, ?, ?)";
        String sqlInv = 
            "INSERT INTO Inventario(id_jugador_partida, dados_rapidos, dados_lentos, peces, bolas_nieve) " +
            "VALUES (?, ?, ?, ?, ?)";
        String sqlCasilla = 
            "INSERT INTO Casilla(id_partida, indice, tipo) VALUES (?, ?, ?)";

        try (Connection con = conectar()) {
            con.setAutoCommit(false);

            // 1) INSERT Partida
            try (PreparedStatement ps = con.prepareStatement(sqlPartida)) {
                ps.setInt(1, id);
                ps.setInt(2, 0); // turno_actual, ajusta si lo guardas
                ps.executeUpdate();
            }

            // 2) INSERT Jugadores + Inventario
            for (Jugador j : jugadores) {
                int idJugadorPartida;
                try (PreparedStatement psJ = con.prepareStatement(sqlJugador, new String[]{"id_jugador_partida"})) {
                    psJ.setInt(1, id);
                    psJ.setString(2, j.getNombre());
                    psJ.setString(3, j.getColor());
                    psJ.setInt(4, j.getPosicion());
                    psJ.setInt(5, j.getTurnosPerdidos());
                    psJ.executeUpdate();

                    // recuperar PK generada
                    try (ResultSet rs = psJ.getGeneratedKeys()) {
                        rs.next();
                        idJugadorPartida = rs.getInt(1);
                    }
                }

                Inventario inv = j.getInventario();
                try (PreparedStatement psI = con.prepareStatement(sqlInv)) {
                    psI.setInt(1, idJugadorPartida);
                    psI.setInt(2, inv.getDadosRapidos());
                    psI.setInt(3, inv.getDadosLentos());
                    psI.setInt(4, inv.getPeces());
                    psI.setInt(5, inv.getBolasNieve());
                    psI.executeUpdate();
                }
            }

            // 3) INSERT Casillas
            try (PreparedStatement psC = con.prepareStatement(sqlCasilla)) {
                List<Casilla> lista = tablero.getCasillas();
                for (int idx = 0; idx < lista.size(); idx++) {
                    Casilla c = lista.get(idx);
                    psC.setInt(1, id);
                    psC.setInt(2, idx);
                    psC.setString(3, c.getTipo());
                    psC.addBatch();
                }
                psC.executeBatch();
            }

            con.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // podrías hacer rollback aquí si quisieras
        }
    }

    /**
     * Carga una partida de la BBDD y reconstruye los objetos Java.
     *
     * @param id Identificador de la partida a cargar
     * @return  Un objeto Partida con los jugadores y el tablero restaurados
     */
    public static Partida cargarPartida(int id) {
        String sqlJug =
            "SELECT jp.id_jugador_partida, jp.nombre, jp.color, jp.posicion, jp.turnos_perdidos, " +
            "       i.dados_rapidos, i.dados_lentos, i.peces, i.bolas_nieve " +
            "  FROM JugadorPartida jp " +
            "  JOIN Inventario i ON i.id_jugador_partida = jp.id_jugador_partida " +
            " WHERE jp.id_partida = ?";

        String sqlCas =
            "SELECT indice, tipo " +
            "  FROM Casilla " +
            " WHERE id_partida = ? " +
            " ORDER BY indice";

        List<Jugador> listaJugadores = new ArrayList<>();
        List<Casilla> listaCasillas       = new ArrayList<>();

        try (Connection con = conectar()) {
            // 1) Leer Jugadores + Inventario
            try (PreparedStatement ps = con.prepareStatement(sqlJug)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String nombre  = rs.getString("nombre");
                        String color   = rs.getString("color");
                        int pos        = rs.getInt("posicion");
                        int tpLost     = rs.getInt("turnos_perdidos");
                        // crear Jugador
                        Jugador j = new Jugador(nombre, color);
                        j.setPosicion(pos);
                        if (tpLost > 0) j.perderTurnos(tpLost);
                        // ajustar Inventario
                        Inventario inv = j.getInventario();
                        // reflejo directo de los contadores
                        while (inv.getDadosRapidos() < rs.getInt("dados_rapidos")) inv.addDadoRapido();
                        while (inv.getDadosLentos()  < rs.getInt("dados_lentos"))  inv.addDadoLento();
                        while (inv.getPeces()        < rs.getInt("peces"))        inv.addPez();
                        while (inv.getBolasNieve()   < rs.getInt("bolas_nieve"))   inv.addBola();
                        listaJugadores.add(j);
                    }
                }
            }

            // 2) Leer Casillas
            try (PreparedStatement ps = con.prepareStatement(sqlCas)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        int idx  = rs.getInt("indice");
                        String t = rs.getString("tipo");
                        Casilla c;
                        switch (t) {
                            case "OSO"               -> c = new Oso(idx);
                            case "AGUJERO"           -> c = new Agujero(idx);
                            case "TRINEO"            -> c = new Trineo(idx);
                            case "INTERROGANTE"      -> c = new Interrogant(idx);
                            case "SUELO_QUEBRADIZO"  -> c = new SueloQuebradizo(idx);
                            default                  -> c = new CasillaNormal(idx);
                        }
                        listaCasillas.add(c);
                    }
                }
            }

            // 3) Reconstruir Tablero sin generar aleatorio
            Tablero tablero = new Tablero();  // genera aleatorio, pero lo vamos a sobreescribir
            // reflejar la lista de casillas leída
            Field f = Tablero.class.getDeclaredField("casillas");
            f.setAccessible(true);
            f.set(tablero, listaCasillas);

            // 4) Devolver todo empaquetado
            Jugador[] arr = listaJugadores.toArray(new Jugador[0]);
            return new Partida(id, arr, tablero);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Clase auxiliar para devolver el resultado de cargarPartida().
     */
    public static class Partida {
        private final int id;
        private final Jugador[] jugadores;
        private final Tablero tablero;

        public Partida(int id, Jugador[] jugadores, Tablero tablero) {
            this.id        = id;
            this.jugadores = jugadores;
            this.tablero   = tablero;
        }

        public int getId() { return id; }
        public Jugador[] getJugadores() { return jugadores; }
        public Tablero getTablero()     { return tablero; }
    }
}
