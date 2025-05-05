package modelo;

import java.util.ArrayList;

/**
 * Implementación concreta de Jugador.
 */
public class Pinguino extends Jugador {
    private Inventario inv;  // tu campo original

    public Pinguino(int posicion, String nombre, String color, Inventario inv) {
        super(posicion, nombre, color);
        this.inv = inv;
        super.setInventario(inv);
    }

    // Constructor simplificado para usar en main()
    public Pinguino(String nombre, String color) {
        super(0, nombre, color);
        this.inv = getInventario();  // ya inicializado en super()
    }

    // Getters / setters originales
    public Inventario getInv() {
        return inv;
    }
    public void setInv(Inventario inv) {
        this.inv = inv;
        super.setInventario(inv);
    }

    public void usarObjeto(Item i) {
        // stub
    }

    public void añadirItem(Item i) {
        getLista().add(i);
    }

    public void quitarItem(Item i) {
        getLista().remove(i);
    }

    private ArrayList<Item> getLista() {
        return getInventario().getLista();
    }
}
