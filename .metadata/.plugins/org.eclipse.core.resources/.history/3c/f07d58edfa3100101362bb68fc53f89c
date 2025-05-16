// src/vista/bbdd.java
package vista;

import modelo.Jugador;
import modelo.Tablero;
import modelo.Casilla;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.*;
import java.sql.*;
import java.util.Base64;

public class bbdd {
    private static final String URL = "jdbc:sqlite:pingui.db";
    private static final String KEY = "MiClaveSecreta12"; // 16 chars

    // Crear taula si no existeix
    static {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS partida(" +
                    "id INTEGER PRIMARY KEY, " +
                    "jugadores TEXT, " +      // JSON encriptat
                    "tablero TEXT)");         // JSON encriptat
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encriptar(String texto) throws Exception {
        SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] enc = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(enc);
    }

    private static String desencriptar(String base64) throws Exception {
        SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] dec = Base64.getDecoder().decode(base64);
        return new String(cipher.doFinal(dec));
    }

    public static void guardarPartida(int id, Jugador[] jugadores, Tablero tablero) {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement ps = conn.prepareStatement(
                 "REPLACE INTO partida(id, jugadores, tablero) VALUES(?,?,?)")) {

            // Convertir estat a JSON (pots usar la llibreria que vulguis)
            String jJug = toJsonJugadores(jugadores);
            String jTab = toJsonTablero(tablero);

            ps.setString(1, Integer.toString(id));
            ps.setString(2, encriptar(jJug));
            ps.setString(3, encriptar(jTab));
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Partida cargarPartida(int id) {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement ps = conn.prepareStatement(
                 "SELECT jugadores, tablero FROM partida WHERE id = ?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String jJugEnc = rs.getString("jugadores");
                String jTabEnc = rs.getString("tablero");

                String jJug = desencriptar(jJugEnc);
                String jTab = desencriptar(jTabEnc);

                Jugador[] jugadores = fromJsonJugadores(jJug);
                Tablero tablero = fromJsonTablero(jTab);
                return new Partida(jugadores, tablero);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ------ Mètodes de conversió a/desde JSON (p. ex. amb Gson o Jackson) ------
    private static String toJsonJugadores(Jugador[] jugadores) {
        // Exemple amb Gson:
        // return new Gson().toJson(jugadores);
        throw new UnsupportedOperationException("Implementa JSON aquí");
    }

    private static String toJsonTablero(Tablero tablero) {
        // return new Gson().toJson(tablero.getCasillas());
        throw new UnsupportedOperationException("Implementa JSON aquí");
    }

    private static Jugador[] fromJsonJugadores(String json) {
        // return new Gson().fromJson(json, Jugador[].class);
        throw new UnsupportedOperationException("Implementa JSON aquí");
    }

    private static Tablero fromJsonTablero(String json) {
        // Casilla[] casillas = new Gson().fromJson(json, Casilla[].class);
        // Tablero t = new Tablero();
        // t.setCasillas(casillas);
        // return t;
        throw new UnsupportedOperationException("Implementa JSON aquí");
    }

    // Classe auxiliar per retornar l’estat carrega
    public static class Partida {
        private Jugador[] jugadores;
        private Tablero tablero;
        public Partida(Jugador[] j, Tablero t) {
            this.jugadores = j;
            this.tablero = t;
        }
        public Jugador[] getJugadores() { return jugadores; }
        public Tablero getTablero() { return tablero; }
    }
}
