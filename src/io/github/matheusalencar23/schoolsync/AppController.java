package io.github.matheusalencar23.schoolsync;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController {
    @FXML
    Label messageLabel;

    @FXML
    TextField textField;

    public void updateMessage() {
        messageLabel.setText("Olá, " + textField.getText() + ", bem vindo!");
    }
}
