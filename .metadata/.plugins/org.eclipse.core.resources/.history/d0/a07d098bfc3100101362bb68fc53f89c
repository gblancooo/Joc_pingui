package vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

public class pantallaSeleccionModoController {

    @FXML
    private void handleNuevaPartida(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaSeleccionJugadores.fxml"));
            Scene escena = new Scene(loader.load());
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(escena);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCargarPartida(ActionEvent event) {
        // Aquí puedes poner una pantalla futura de carga, por ahora solo mensaje
        System.out.println("Funcionalidad de cargar partida aún no implementada.");
    }
}
