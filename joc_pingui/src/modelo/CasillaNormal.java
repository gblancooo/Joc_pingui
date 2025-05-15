package modelo;
import controlador.gestorPartidas;

public class CasillaNormal extends Casilla {
    public CasillaNormal(int idx, java.util.List<Jugador> occ) {
        super(idx, occ);
    }

    @Override
    public void realizarAccion(Jugador j, gestorPartidas gp) {
        // Sin efecto
    }
}
