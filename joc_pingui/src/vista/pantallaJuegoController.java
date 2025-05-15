package vista;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import controlador.gestorPartidas;
import modelo.Casilla;
import modelo.Jugador;
import java.util.List;

public class pantallaJuegoController {
    @FXML private GridPane grid;
    @FXML private Button tirarBtn;
    private gestorPartidas gp = null;

    @FXML public void initialize() {
        gp = gestorPartidas.getTablero()==null ? null : null;
        refrescarTablero();
    }

    private void refrescarTablero() {
        grid.getChildren().clear();
        List<Casilla> casillas = gestorPartidas.getTablero().getCasillas();
        for (int i = 0; i < casillas.size(); i++) {
            Casilla c = casillas.get(i);
            Circle circle = new Circle(20);
            switch (c.getClass().getSimpleName()) {
                case "Oso": circle.setFill(Color.BROWN); break;
                case "Agujero": circle.setFill(Color.DARKGRAY); break;
                case "Trineo": circle.setFill(Color.BLUE); break;
                case "Interrogant": circle.setFill(Color.ORANGE); break;
                default: circle.setFill(Color.LIGHTBLUE); break;
            }
            grid.add(circle, i % 10, i / 10);
            // fichas:
            for (Jugador j : c.getJugadoresActuales()) {
                Circle p = new Circle(5, Color.web(j.getColor()));
                grid.add(p, i % 10, i / 10);
            }
        }
    }

    @FXML public void onTirar() {
        gp = gestorPartidas.getTablero()==null ? gp : gp;
        gp.jugarTurno();
        refrescarTablero();
    }
}
