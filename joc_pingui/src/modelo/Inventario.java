package modelo;

import java.util.ArrayList;

/**
 * Inventario de cada jugador: peces, bolas de nieve y dados.
 */
public class Inventario {
    private ArrayList<Item> lista;   // tu lista original de Item
    private int peces;
    private int bolasDeNieve;
    private int dadosNormales;
    private int dadosRapidos;
    private int dadosLentos;

    public Inventario(ArrayList<Item> lista) {
        this.lista = lista;
        this.peces = 0;
        this.bolasDeNieve = 0;
        this.dadosNormales = 3;
        this.dadosRapidos = 0;
        this.dadosLentos = 0;
    }

    // Getters / setters originales
    public ArrayList<Item> getLista() {
        return lista;
    }
    public void setLista(ArrayList<Item> lista) {
        this.lista = lista;
    }

    // Getters nuevos
    public int getPeces()         { return peces; }
    public int getBolasDeNieve()  { return bolasDeNieve; }
    public int getDadosNormales() { return dadosNormales; }
    public int getDadosRapidos()  { return dadosRapidos; }
    public int getDadosLentos()   { return dadosLentos; }

    // Usar items
    public void usarPez()           { if (peces > 0) peces--; }
    public void usarBolaDeNieve()   { if (bolasDeNieve > 0) bolasDeNieve--; }
    public void usarDadoNormal()    { if (dadosNormales > 0) dadosNormales--; }
    public void usarDadoRapido()    { if (dadosRapidos > 0) dadosRapidos--; }
    public void usarDadoLento()     { if (dadosLentos > 0) dadosLentos--; }

    // Añadir items con topes
    public void agregarPez() {
        if (peces < 2) peces++;
    }
    public void agregarBolasDeNieve(int n) {
        bolasDeNieve = Math.min(6, bolasDeNieve + n);
    }
    public void agregarDadoRapido() { dadosRapidos++; }
    public void agregarDadoLento()  { dadosLentos++; }
}
