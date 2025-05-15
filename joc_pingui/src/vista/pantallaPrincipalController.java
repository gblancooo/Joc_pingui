package vista;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class pantallaPrincipalController {
    @FXML public void onInicio() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaSeleccionJugadores.fxml"));
        Stage stage = (Stage) /* algún nodo del actual */ null; 
        stage.setScene(new Scene(loader.load()));
    }
    @FXML public void onSalir() {
        System.exit(0);
    }
}
