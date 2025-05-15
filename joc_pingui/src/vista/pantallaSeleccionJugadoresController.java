package vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import controlador.gestorJugador;
import modelo.Jugador;

import java.util.List;

public class pantallaSeleccionJugadoresController {

    @FXML private TextField txtNombre;
    @FXML private ColorPicker pickerColor;
    @FXML private Button btnAdd;
    @FXML private Button btnStart;

    // Gestor de jugadors compartit
    private static gestorJugador gj = new gestorJugador();

    @FXML
    private void onAdd(ActionEvent event) {
        String nom = txtNombre.getText().trim();
        String col = pickerColor.getValue().toString();
        if (!nom.isEmpty()) {
            gj.addJugador(new Jugador(nom, col));
            txtNombre.clear();
        }
    }

    @FXML
    private void onStart(ActionEvent event) {
        // No començar si no hi ha com a mínim 1 jugador
        List<Jugador> llista = gj.getJugadores();
        if (llista.isEmpty()) return;

        try {
            // Carrega l'FXML de la pantalla de joc
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/pantallaJuego.fxml")
            );
            Parent root = loader.load();

            // Posa els jugadors dins del controlador de joc
            vista.pantallaJuegoController ctrl = loader.getController();
            ctrl.setJugadores(llista);

            // Canvia d'escena
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
