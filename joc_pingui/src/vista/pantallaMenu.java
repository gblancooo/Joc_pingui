// src/vista/pantallaMenu.java
package vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

public class pantallaMenu {

    /**
     * Crida quan es prem el botó "Nou Joc" al menú.
     */
    @FXML
    private void onNuevoJuego(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/pantallaSeleccionJugadores.fxml"));
            Scene escena = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(escena);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Crida quan es prem el botó "Cargar Joc" al menú.
     */
    @FXML
    private void onCargarJuego(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/pantallaPrincipal.fxml"));
            Scene escena = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(escena);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Crida quan es prem el botó "Sortir" al menú.
     */
    @FXML
    private void onSalir() {
        System.exit(0);
    }
}
