package vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
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

    // Nuevo ComboBox para selección de número de jugadores
    @FXML private ComboBox<Integer> comboJugadores;

    // Gestor de jugadors compartit
    private static gestorJugador gj = new gestorJugador();

    @FXML
    public void initialize() {
        // Carga opciones 1 a 4 en el ComboBox
        comboJugadores.getItems().addAll(1, 2, 3, 4);
    }

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
        Integer seleccion = comboJugadores.getValue();

        // Si se ha usado el combo para seleccionar número
        if (seleccion != null && seleccion >= 1 && seleccion <= 4) {
            
            // Colores fijos para 4 jugadores
            String[] colores = { "#0000FF", "#FF0000", "#00FF00", "#FFFF00" };

            // Añadir jugadores automáticos
            for (int i = 0; i < seleccion; i++) {
                gj.addJugador(new Jugador("Jugador " + (i + 1), colores[i]));
            }

        } else {
            // Modo antiguo: usar jugadores añadidos manualmente
            List<Jugador> llista = gj.getJugadores();
            if (llista.isEmpty()) return;
        }

        try {
            // Cargar pantalla de juego
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/pantallaJuego.fxml")
            );
            Parent root = loader.load();

            // Pasar jugadores al controlador de juego
            vista.pantallaJuegoController ctrl = loader.getController();
            ctrl.setJugadores(gj.getJugadores());

            // Cambiar escena
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public ComboBox<Integer> getComboJugadores() {
		return comboJugadores;
	}

	public void setComboJugadores(ComboBox<Integer> comboJugadores) {
		this.comboJugadores = comboJugadores;
	}
}
