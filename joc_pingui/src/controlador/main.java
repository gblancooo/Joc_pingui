package controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import modelo.Pinguino;
import java.util.Arrays;
import vista.pantallaPrincipalController;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 1) Crear tablero
        gestorTablero tablero = new gestorTablero();
        // 2) Crear jugadores
        Pinguino p1 = new Pinguino("Alice", "rojo");
        Pinguino p2 = new Pinguino("Bob",   "azul");
        gestorPartidas gp = new gestorPartidas(tablero, Arrays.asList(p1, p2));

        // 3) Cargar UI
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/pantallaPrincipal.fxml")
        );
        Parent root = loader.load();
        // 4) Inyectar gestor de partida
        pantallaPrincipalController ctrl = loader.getController();
        ctrl.setGestorPartidas(gp);

        // 5) Mostrar ventana
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("El Juego del Pingüino");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
