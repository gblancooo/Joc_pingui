package modelo;

/** Si en tu juego hay focas; por defecto sin efecto */
public class Foca extends Casilla {
    public Foca(int idx, java.util.List<Jugador> occ) {
        super(idx, occ);
    }
    @Override
    public void realizarAccion(Jugador j, controlador.gestorPartidas gp) {
        // Podrías robar un pez al jugador, etc.
    }
}
