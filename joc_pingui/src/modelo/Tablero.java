package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tablero {

    public static final int NUM_CASILLAS = 50;

    private List<Casilla> casillas;

    public Tablero() {
        casillas = new ArrayList<>();
        generarCasillasAleatorias();
    }

    private void generarCasillasAleatorias() {
        Random rnd = new Random();

        // Inicialment totes NORMAL
        for (int i = 0; i < NUM_CASILLAS; i++) {
            casillas.add(new Casilla(i, "NORMAL"));
        }

        // Fixem límits per tipus especials
        int numOsos = 5;
        int numAgujeros = 5;
        int numTrineos = 4;
        int numInterrogants = 6;

        // Assignem tipus especials en posicions aleatòries
        assignarTipusAleatori("OSO", numOsos, rnd);
        assignarTipusAleatori("AGUJERO", numAgujeros, rnd);
        assignarTipusAleatori("TRINEO", numTrineos, rnd);
        assignarTipusAleatori("INTERROGANTE", numInterrogants, rnd);
    }

    private void assignarTipusAleatori(String tipus, int quantitat, Random rnd) {
        int assignats = 0;
        while (assignats < quantitat) {
            int pos = rnd.nextInt(NUM_CASILLAS);

            // Evitem posició 0 (inici) i 49 (final), i evitem sobreescriure
            Casilla actual = casillas.get(pos);
            if (pos != 0 && pos != NUM_CASILLAS - 1 && actual.getTipo().equals("NORMAL")) {
                casillas.set(pos, new Casilla(pos, tipus));
                assignats++;
            }
        }
    }

    public Casilla getCasilla(int index) {
        if (index < 0) index = 0;
        if (index >= NUM_CASILLAS) index = NUM_CASILLAS - 1;
        return casillas.get(index);
    }

    public List<Casilla> getCasillas() {
        return casillas;
    }
}
