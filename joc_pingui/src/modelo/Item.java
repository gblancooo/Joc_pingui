package modelo;

/**
 * Classe base per a qualsevol objecte recollible.
 */
public abstract class Item {
    private String nombre;
    public Item(String nombre) { this.nombre = nombre; }
    public String getNombre()  { return nombre; }
    public abstract void aplicar(Jugador j);
}
