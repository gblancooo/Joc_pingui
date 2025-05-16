package controlador;

import modelo.Tablero;



public class gestorTablero {
    private Tablero tablero = new Tablero();

    public Tablero getTablero() {
        return tablero;
    }

    public void resetTablero() {
        tablero = new Tablero();
    }
    
    public gestorTablero() {
        this.tablero = new Tablero();
    }

    /** Nuevo constructor para inyectar un tablero existente **/
    public gestorTablero(Tablero tableroCargado) {
        this.tablero = tableroCargado;
    }

   
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
}
