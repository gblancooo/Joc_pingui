package vista;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class pantallaJuegoController implements Initializable {

    // Menu items
    @FXML private MenuItem newGame;
    @FXML private MenuItem saveGame;
    @FXML private MenuItem loadGame;
    @FXML private MenuItem quitGame;

    // Texts
    @FXML private Text dadoResultText;
    @FXML private Text rapido_t;
    @FXML private Text lento_t;
    @FXML private Text peces_t;
    @FXML private Text nieve_t;
    @FXML private Text eventos;

    // Players' pieces
    @FXML private Circle P1;
    @FXML private Circle P2;
    @FXML private Circle P3;
    @FXML private Circle P4;

    private final int COLUMNS = 5;

    // Multiplayer support
    private int numeroJugadores = 1;
    private int currentPlayerIndex = 0;
    private int p1Position = 0;
    private int p2Position = 0;
    private int p3Position = 0;
    private int p4Position = 0;

    /**
     * Called by selection controller before showing this screen
     */
    public void setNumeroJugadores(int n) {
        this.numeroJugadores = n;
        this.currentPlayerIndex = 0;
        eventos.setText("Turno de Jugador 1");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initial message
        eventos.setText("¡El juego ha comenzado!");
    }

    @FXML
    private void handleDado(ActionEvent event) {
        Random rand = new Random();
        int diceResult = rand.nextInt(6) + 1;

        // Show dice roll
        dadoResultText.setText("Ha salido: " + diceResult);

        // Move current player
        switch (currentPlayerIndex) {
            case 0:
                moveP1(diceResult);
                break;
            case 1:
                if (numeroJugadores >= 2) moveP2(diceResult);
                break;
            case 2:
                if (numeroJugadores >= 3) moveP3(diceResult);
                break;
            case 3:
                if (numeroJugadores >= 4) moveP4(diceResult);
                break;
        }
        // Advance turn
        nextTurn();
    }

    /**
     * Advance to next player's turn
     */
    private void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % numeroJugadores;
        eventos.setText("Turno de Jugador " + (currentPlayerIndex + 1));
    }

    private void moveP1(int steps) {
        p1Position = boundPosition(p1Position + steps);
        int row = p1Position / COLUMNS;
        int col = p1Position % COLUMNS;
        GridPane.setRowIndex(P1, row);
        GridPane.setColumnIndex(P1, col);
    }

    private void moveP2(int steps) {
        p2Position = boundPosition(p2Position + steps);
        int row = p2Position / COLUMNS;
        int col = p2Position % COLUMNS;
        GridPane.setRowIndex(P2, row);
        GridPane.setColumnIndex(P2, col);
    }

    private void moveP3(int steps) {
        p3Position = boundPosition(p3Position + steps);
        int row = p3Position / COLUMNS;
        int col = p3Position % COLUMNS;
        GridPane.setRowIndex(P3, row);
        GridPane.setColumnIndex(P3, col);
    }

    private void moveP4(int steps) {
        p4Position = boundPosition(p4Position + steps);
        int row = p4Position / COLUMNS;
        int col = p4Position % COLUMNS;
        GridPane.setRowIndex(P4, row);
        GridPane.setColumnIndex(P4, col);
    }

    /** Ensure position does not exceed grid size */
    private int boundPosition(int pos) {
        int maxCells = COLUMNS * 10; // 5 columns * 10 rows
        return pos >= maxCells ? maxCells - 1 : pos;
    }

    // --- Existing handlers preserved ---

    @FXML
    private void handleNewGame() {
        System.out.println("New game.");
        // TODO
    }

    @FXML
    private void handleSaveGame() {
        System.out.println("Save game.");
        // TODO
    }

    @FXML
    private void handleLoadGame() {
        System.out.println("Load game.");
        // TODO
    }

    @FXML
    private void handleQuitGame() {
        System.out.println("Quit game.");
        System.exit(0);
    }

    @FXML
    private void handleRapido() {
        System.out.println("Fast.");
        // TODO
    }

    @FXML
    private void handleLento() {
        System.out.println("Slow.");
        // TODO
    }

    @FXML
    private void handlePeces() {
        System.out.println("Fish.");
        // TODO
    }

    @FXML
    private void handleNieve() {
        System.out.println("Snow.");
        // TODO
    }
}
