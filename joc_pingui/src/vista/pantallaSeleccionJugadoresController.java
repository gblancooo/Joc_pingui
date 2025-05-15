package vista;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import modelo.Jugador;
import controlador.gestorPartidas;
import controlador.gestorTablero;
import java.util.*;

public class pantallaSeleccionJugadoresController {
    @FXML private TextField nombre1, color1, nombre2, color2;

    @FXML public void onJugar() throws Exception {
        List<Jugador> js = new ArrayList<>();
        js.add(new Jugador(nombre1.getText(), color1.getText()));
        js.add(new Jugador(nombre2.getText(), color2.getText()));
        gestorTablero gt = new gestorTablero();
        new gestorPartidas(gt, js);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaJuego.fxml"));
        Stage stage = (Stage) nombre1.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }
}
