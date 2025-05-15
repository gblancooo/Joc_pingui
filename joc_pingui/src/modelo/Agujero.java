package modelo;
import controlador.gestorPartidas;

public class Agujero extends Casilla {
    public Agujero(int idx, java.util.List<Jugador> occ) {
        super(idx, occ);
    }
    @Override
    public void realizarAccion(Jugador j, gestorPartidas gp) {
        int ant = gp.getTablero().buscarAnteriorAgujero(getPosicion());
        gp.getTablero().getCasillas().get(getPosicion()).quitarJugador(j);
        j.setPosicion(ant);
        gp.getTablero().getCasillas().get(ant).añadirJugador(j);
    }
}
