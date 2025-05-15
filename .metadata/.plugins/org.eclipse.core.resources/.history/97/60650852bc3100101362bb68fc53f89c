package modelo;

public class Jugador {
    private String nombre, color;
    private int posicion;
    private Inventario inventario;

    public Jugador(String nombre, String color) {
        this.nombre = nombre; this.color = color;
        this.posicion = 0;
        this.inventario = new Inventario();
    }

    public String getNombre()               { return nombre; }
    public String getColor()                { return color;  }
    public int getPosicion()                { return posicion; }
    public Inventario getInventario()       { return inventario; }

    public void mover(int pasos) {
        posicion += pasos;
        if (posicion<0) posicion=0;
        if (posicion>=Tablero.NUM_CASILLAS) posicion=Tablero.NUM_CASILLAS-1;
    }
    public void setPosicion(int pos) {
        if (pos<0) pos=0;
        if (pos>=Tablero.NUM_CASILLAS) pos=Tablero.NUM_CASILLAS-1;
        this.posicion = pos;
    }
}
