package modelo;

public class Jugador {
    private String nombre, color;
    private int posicion;
    private Inventario inventario;

    // Nuevo atributo para turnos perdidos
    private int turnosPerdidos = 0;

    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        this.posicion = 0;
        this.inventario = new Inventario();
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void mover(int pasos) {
        this.posicion += pasos;
    }

    // Métodos para gestionar turnos perdidos
    public void perderTurnos(int n) {
        turnosPerdidos += n;
    }

    public boolean tieneTurnoPerdido() {
        return turnosPerdidos > 0;
    }

    public void descontarTurnoPerdido() {
        if (turnosPerdidos > 0) turnosPerdidos--;
    }

    public int getTurnosPerdidos() {
        return turnosPerdidos;
    }
}
