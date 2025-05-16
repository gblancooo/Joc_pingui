package vista;

import controlador.gestorPartidas;
import controlador.gestorTablero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import modelo.Jugador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class pantallaSeleccionModoController {

	 @FXML
	    private void handleNewGame(ActionEvent event) throws IOException {
	    // 1) Pedir número de jugadores (mínimo 2, máximo 4)
	    TextInputDialog numDlg = new TextInputDialog("2");
	    numDlg.setTitle("Nueva Partida");
	    numDlg.setHeaderText("¿Cuántos jugadores van a jugar? (2-4)");
	    numDlg.setContentText("Número de jugadores:");
	    Optional<String> numRes = numDlg.showAndWait();
	    if (numRes.isEmpty()) return;

	    int num;
	    try {
	        num = Integer.parseInt(numRes.get());
	        if (num < 2 || num > 4) throw new NumberFormatException();
	    } catch (NumberFormatException ex) {
	        return; // cancelamos si es inválido
	    }

	    // 2) Crear jugadores con nombre "Jugador1", "Jugador2", ... y color vacío
	    List<Jugador> lista = new ArrayList<>();
	    for (int i = 1; i <= num; i++) {
	        lista.add(new Jugador("Jugador" + i, ""));
	    }

	    // 3) Cargamos el FXML de juego y obtenemos el controlador
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaJuego.fxml"));
	    Scene scene = new Scene(loader.load());
	    pantallaJuegoController juegoCtrl = loader.getController();

	    // 4) Inyectar lista y arrancar juego
	    juegoCtrl.setJugadores(lista);

	    // 5) Mostramos la escena
	    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	}

    @FXML
    private void handleLoadGame(ActionEvent event) {
        // Pide ID al usuario
        TextInputDialog dlg = new TextInputDialog();
        dlg.setTitle("Cargar partida");
        dlg.setHeaderText("Introduce el ID de la partida a cargar:");
        dlg.setContentText("ID:");
        Optional<String> res = dlg.showAndWait();
        if (res.isEmpty()) return;

        int id;
        try {
            id = Integer.parseInt(res.get());
        } catch (NumberFormatException ex) {
            
            return;
        }

        // Carga de la BBDD
        gestorPartidas gp = new gestorPartidas();
        vista.bbdd.Partida partida = gp.cargar(id);
        if (partida == null) {
           
            return;
        }

        try {
            // Abre la pantalla de juego e inyecta los datos
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaJuego.fxml"));
            Scene scene = new Scene(loader.load());
            pantallaJuegoController juegoCtrl = loader.getController();

            // Inyecta jugadores y tablero
            List<Jugador> jugadores = List.of(partida.getJugadores());
            juegoCtrl.setJugadores(jugadores);
            juegoCtrl.setGestorTablero(new gestorTablero(partida.getTablero()));

            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
