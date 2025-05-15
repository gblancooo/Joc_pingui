package vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class pantallaPrincipalController {

    @FXML private MenuItem newGame;
    @FXML private MenuItem saveGame;
    @FXML private MenuItem loadGame;
    @FXML private MenuItem quitGame;

    @FXML private TextField userField;
    @FXML private PasswordField passField;
    @FXML private Button loginButton;
    @FXML private Button registerButton;

    @FXML
    private void handleNewGame(ActionEvent event) { /* ... */ }

    @FXML
    private void handleSaveGame(ActionEvent event) { /* ... */ }

    @FXML
    private void handleLoadGame(ActionEvent event) { /* ... */ }

    @FXML
    private void handleQuitGame(ActionEvent event) {
        System.exit(0);
    }

    /** Ara sí: al fer Login carreguem la següent FXML */
    @FXML
    private void handleLogin(ActionEvent event) {
        String user = userField.getText();
        String pass = passField.getText();

        // (Opcional) valida usuari/pass aquí abans de continuar...

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaSeleccionJugadores.fxml"));
            Scene escena = new Scene(loader.load());
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(escena);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** I si vols que el registre també porti a una altra pantalla: */
    @FXML
    private void handleRegister(ActionEvent event) {
        try {
            // per exemple, tornar al mateix FXML de registre o una vista d’alta
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaRegistro.fxml"));
            Scene escena = new Scene(loader.load());
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(escena);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
