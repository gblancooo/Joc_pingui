package modelo;
import controlador.gestorPartidas;

public class Trineo extends Casilla {
    public Trineo(int idx, java.util.List<Jugador> occ) {
        super(idx, occ);
    }

    @Override
    public void realizarAccion(Jugador j, gestorPartidas gp) {
        int nxt = gp.getTablero().siguienteIndiceDe(Trineo.class, getPosicion());
        gp.getTablero().getCasillas().get(getPosicion()).quitarJugador(j);
        j.setPosicion(nxt);
        gp.getTablero().getCasillas().get(nxt).añadirJugador(j);
    }
}
