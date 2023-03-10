package com.example.loginwindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class HelloController {

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    public void login(ActionEvent event) {

        Window owner = submitButton.getScene().getWindow();

        if (userField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Fehler!",
                    "Bitte gebe einen Benutzernamen an!");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Fehler!",
                    "Bitte gebe dein Passwort ein!");
            return;
        }

        String emailId = userField.getText();
        String password = passwordField.getText();
        String realPW = "passwort";
        String realUN = "JavaFX";

        if (emailId.equals(realUN) && password.equals(realPW)) {
            infoBox("Sie sind nun angemeldet!", "Erfolgreich", "Login");
        } else {
            showAlert(Alert.AlertType.ERROR, owner, "Fehler!",
                    "Nutzername oder Passwort falsch!");
        }
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
