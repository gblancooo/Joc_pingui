package modelo;

public class Foca extends Casilla {
    public Foca(int posicion) {
        super(posicion, "FOCA");
    }
    public void efecto(Jugador j) {
        j.getInventario().addPez();
    }
}
