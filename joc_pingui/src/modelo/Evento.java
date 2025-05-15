package modelo;
import controlador.gestorPartidas;
import java.util.Random;

public class Evento extends Casilla {
    private static Random r = new Random();
    public Evento(int idx, java.util.List<Jugador> occ) {
        super(idx, occ);
    }

    @Override
    public void realizarAccion(Jugador j, gestorPartidas gp) {
        int e = r.nextInt(4);
        switch (e) {
            case 0: j.getInventario().addPez(); break;
            case 1: j.getInventario().addNieve(r.nextInt(3) + 1); break;
            case 2: j.getInventario().addDadoRapido(); break;
            case 3: j.getInventario().addDadoLento(); break;
        }
    }
}
