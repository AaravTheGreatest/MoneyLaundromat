package moneyLaundromat;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MenuController {
    @FXML private TextField vaultCap;
    
    @FXML
    private void dollarSighValue(MouseEvent event) {
        vaultCap.setPromptText("$" + vaultCap.getPromptText());
    }

    @FXML
    private void clearToPlaceholder(MouseEvent event) {
        vaultCap.setPromptText("Vault capacity...");
    }
    @FXML
    private void game(ActionEvent event) throws IOException {
        // Load the next FXML
        Parent roadRoot = FXMLLoader.load(getClass().getResource("road.fxml"));
        Scene scene = ((Node) event.getSource()).getScene();

        // Fade out current scene
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), scene.getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(e -> {
            scene.setRoot(roadRoot);
            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), roadRoot);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        });
        fadeOut.play();
    }
}

