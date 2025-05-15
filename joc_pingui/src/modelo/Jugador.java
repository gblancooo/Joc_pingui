package modelo;

import controlador.gestorPartidas;

public class Jugador {
    private String nombre;
    private String color;
    private int posicion;
    private Inventario inventario;

    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color  = color;
        this.posicion = 0;
        this.inventario = new Inventario();
        // auto-registrarse en el tablero
        gestorPartidas.getTablero().getCasillas().get(0).añadirJugador(this);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String n) { nombre = n; }

    public String getColor() { return color; }
    public void setColor(String c) { color = c; }

    public int getPosicion() { return posicion; }
    public void setPosicion(int p) { posicion = p; }

    public Inventario getInventario() { return inventario; }
}
