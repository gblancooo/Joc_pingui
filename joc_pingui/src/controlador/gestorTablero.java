package controlador;

import modelo.*;
import java.util.*;

/**
 * Genera y mantiene un tablero de 50 casillas aleatorias.
 */
public class gestorTablero {
    private final List<Casilla> casillas = new ArrayList<>(50);

    public gestorTablero() {
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            switch (r.nextInt(5)) {
                case 0: casillas.add(new Oso(i, new ArrayList<>())); break;
                case 1: casillas.add(new Agujero(i, new ArrayList<>())); break;
                case 2: casillas.add(new Trineo(i, new ArrayList<>())); break;
                case 3: casillas.add(new Interrogant(i, new ArrayList<>())); break;
                default: casillas.add(new CasillaNormal(i, new ArrayList<>())); break;
            }
        }
        casillas.set(0, new CasillaNormal(0, new ArrayList<>()));
        casillas.set(49, new CasillaNormal(49, new ArrayList<>()));
    }

    public List<Casilla> getCasillas() {
        return casillas;
    }

    /** Busca siguiente índice de casilla tipo cls tras idx */
    public int siguienteIndiceDe(Class<? extends Casilla> cls, int idx) {
        for (int i = idx + 1; i < casillas.size(); i++) {
            if (cls.isInstance(casillas.get(i))) return i;
        }
        return idx;
    }

    /** Busca anterior agujero (para Agujero) */
    public int buscarAnteriorAgujero(int idx) {
        for (int i = idx - 1; i >= 0; i--) {
            if (casillas.get(i) instanceof Agujero) return i;
        }
        return 0;
    }
}
