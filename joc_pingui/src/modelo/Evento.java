package modelo;

import java.util.Random;

public class Evento {
    private static Random rnd = new Random();

    public static void activarEvento(Jugador jugador) {
        Inventario inv = jugador.getInventario();
        int tipo = rnd.nextInt(4);
        switch (tipo) {
            case 0:
                if (inv.addPez()) System.out.println(jugador.getNombre() + " ha obtingut un peix!");
                break;
            case 1:
                int n = 1 + rnd.nextInt(3), añadidas = 0;
                for (int i = 0; i < n; i++) if (inv.addBola()) añadidas++;
                System.out.println(jugador.getNombre() + " ha obtingut " + añadidas + " boles de neu!");
                break;
            case 2:
                if (inv.addDado()) System.out.println(jugador.getNombre() + " ha obtingut un dau (ràpid)!");
                break;
            case 3:
                if (inv.addDado()) System.out.println(jugador.getNombre() + " ha obtingut un dau (lent)!");
                break;
        }
    }
}
