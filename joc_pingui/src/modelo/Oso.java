package modelo;
import controlador.gestorPartidas;

public class Oso extends Casilla {
    public Oso(int idx, java.util.List<Jugador> occ) {
        super(idx, occ);
    }

    @Override
    public void realizarAccion(Jugador j, gestorPartidas gp) {
        if (!j.getInventario().usarPez()) {
            gp.getTablero().getCasillas().get(getPosicion()).quitarJugador(j);
            j.setPosicion(0);
            gp.getTablero().getCasillas().get(0).añadirJugador(j);
        }
    }
}
