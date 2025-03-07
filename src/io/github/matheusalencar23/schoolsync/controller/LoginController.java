package io.github.matheusalencar23.schoolsync.controller;

import io.github.matheusalencar23.schoolsync.SceneManager;
import io.github.matheusalencar23.schoolsync.exceptions.InvalidCredentials;
import io.github.matheusalencar23.schoolsync.exceptions.ResourceNotFoundException;
import io.github.matheusalencar23.schoolsync.model.User;
import io.github.matheusalencar23.schoolsync.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            if (username.isEmpty() || password.isEmpty()) {
                errorLabel.setText("Por favor, informe usuário e senha");
                return;
            }

            UserService service = new UserService();
            User user = service.login(username, password);

            if (user.getRole().equals("STUDENT")) {
                SceneManager.switchTo("SchollSync | " + user.getUsername(), "view/student-dashboard.fxml");
            }
        } catch (InvalidCredentials e) {
            System.out.println(e.getMessage());
            errorLabel.setText("Credenciais inválidas");
        }
    }
}
