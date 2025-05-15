package modelo;

public class Inventario {
    private int dadosRapidos = 0;
    private int dadosLentos  = 0;
    private int peces        = 0;
    private int bolasDeNieve= 0;

    public boolean usarPez() {
        if (peces > 0) { peces--; return true; }
        return false;
    }

    public void addPez() { if (peces < 2) peces++; }
    public void addNieve(int k) { bolasDeNieve = Math.min(6, bolasDeNieve + k); }
    public void addDadoRapido() { dadosRapidos = Math.min(3, dadosRapidos + 1); }
    public void addDadoLento()  { dadosLentos  = Math.min(3, dadosLentos + 1); }

    public int getDadosRapidos() { return dadosRapidos; }
    public int getDadosLentos()  { return dadosLentos; }
    public int getPeces()        { return peces; }
    public int getBolasDeNieve(){ return bolasDeNieve; }
}
