package modelo;

import java.util.*;

public class Tablero {
    public static final int NUM_CASILLAS = 50;
    private Casilla[] casillas;

    public Tablero() {
        casillas = new Casilla[NUM_CASILLAS];
        generarCasillasAleatorias();
    }

    private void generarCasillasAleatorias() {
        List<Integer> pos = new ArrayList<>();
        for (int i=0;i<NUM_CASILLAS;i++) pos.add(i);
        Collections.shuffle(pos);

        for(int i=0;i<5;i++) casillas[pos.remove(0)] = new Oso(pos.get(0));
        for(int i=0;i<5;i++) casillas[pos.remove(0)] = new Agujero(pos.get(0));
        for(int i=0;i<5;i++) casillas[pos.remove(0)] = new Trineo(pos.get(0));
        for(int i=0;i<5;i++) casillas[pos.remove(0)] = new Interrogant(pos.get(0));
        for(int i=0;i<NUM_CASILLAS;i++)
            if(casillas[i]==null) casillas[i] = new CasillaNormal(i);
    }

    public Casilla getCasilla(int posicion) {
        if (posicion<0) return casillas[0];
        if (posicion>=NUM_CASILLAS) return casillas[NUM_CASILLAS-1];
        return casillas[posicion];
    }

    public Casilla[] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[] c) {
        if (c.length!=NUM_CASILLAS)
            throw new IllegalArgumentException("Mida incorrecta");
        this.casillas = c;
    }
}
