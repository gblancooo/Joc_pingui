package modelo;

import controlador.gestorPartidas;
import java.util.ArrayList;

/**
 * Representa a un jugador (pingüí).
 */
public abstract class Jugador {
    private int posicion;
    private String nombre;
    private String color;
    private Inventario inventario;

    public Jugador(int posicion, String nombre, String color) {
        super();
        this.posicion = posicion;
        this.nombre   = nombre;
        this.color    = color;
        this.inventario = new Inventario(new ArrayList<>());  // inicializa lista vacía
    }

    // Getters y setters originales
    public int getPosicion()      { return posicion; }
    public void setPosicion(int posicion) {
        this.posicion = Math.max(0, Math.min(posicion, 49));
    }

    public String getNombre()     { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor()      { return color; }
    public void setColor(String color) {
        this.color = color;
    }

    // Inventario
    public Inventario getInventario() {
        return inventario;
    }
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    // Métodos de juego
    public void tirarDado(int maximoDado) {
        // permanece como stub, lanzar("maximoDado")
    }

    public void moverPosicion(int p) {
        setPosicion(this.posicion + p);
    }

    /** Retrocede al agujero (“Forat”) anterior en el tablero */
    public void retrocederAlForatAnterior() {
        int pos = this.posicion - 1;
        while (pos >= 0) {
            if (gestorPartidas.getTablero()
                .getCasillas().get(pos) instanceof Agujero) {
                setPosicion(pos);
                return;
            }
            pos--;
        }
        setPosicion(0);
    }
}
