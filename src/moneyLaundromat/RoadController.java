package moneyLaundromat;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class RoadController {
    @FXML private Canvas gameCanvas;

    private final Player player = GameState.getPlayer();

    public void initialize() {
        draw();
        gameCanvas.setFocusTraversable(true);
        gameCanvas.requestFocus();
        gameCanvas.setOnKeyPressed(this::handleKeyPress);
    }

    private void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case W -> player.move(0, -5);
            case S -> player.move(0, 5);
            case A -> player.move(-5, 0);
            case D -> player.move(5, 0);
            default -> {}
        }
        draw();
    }

    private void draw() {
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());
        player.draw(gc);
    }
}

