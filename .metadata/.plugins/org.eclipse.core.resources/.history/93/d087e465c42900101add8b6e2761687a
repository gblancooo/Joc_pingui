package vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

public class pantallaSeleccionJugadoresController {

    @FXML private Spinner<Integer> spinnerNumJugadores;

    @FXML
    public void initialize() {
        // Rango 1–4, valor inicial 1
        spinnerNumJugadores.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4, 1)
        );
    }

    @FXML
    private void handleEjecutar() {
        int num = spinnerNumJugadores.getValue();

        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/pantallaJuego.fxml")
            );
            Parent root = loader.load();

            // Pasar el nº de jugadores al controlador existente
            vista.pantallaJuegoController ctrl = loader.getController();
            ctrl.setNumeroJugadores(num);

            Stage stage = new Stage();
            stage.setTitle("Pantalla de Juego");
            stage.setScene(new Scene(root));
            stage.show();

            // Cerrar esta ventana
            spinnerNumJugadores.getScene().getWindow().hide();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
