package modelo;

public class Inventario {
    private int dados, peces, bolasNieve;
    private static final int MAX_DADOS = 3, MAX_PECES = 2, MAX_BOLAS = 6;

    public Inventario() { this.dados = this.peces = this.bolasNieve = 0; }

    public boolean addDado()    { if (dados<MAX_DADOS){dados++;return true;}return false; }
    public boolean usarDado()   { if (dados>0){dados--;return true;}return false; }
    public int getDados()       { return dados; }

    public boolean addPez()     { if (peces<MAX_PECES){peces++;return true;}return false; }
    public boolean usarPez()    { if (peces>0){peces--;return true;}return false; }
    public int getPeces()       { return peces; }

    public boolean addBola()    { if (bolasNieve<MAX_BOLAS){bolasNieve++;return true;}return false; }
    public boolean usarBola()   { if (bolasNieve>0){bolasNieve--;return true;}return false; }
    public int getBolasNieve()  { return bolasNieve; }
}
