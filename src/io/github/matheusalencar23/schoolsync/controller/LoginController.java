package io.github.matheusalencar23.schoolsync.controller;

import io.github.matheusalencar23.schoolsync.SceneManager;
import io.github.matheusalencar23.schoolsync.dao.user.UserDao;
import io.github.matheusalencar23.schoolsync.dao.user.UserDaoImpl;
import io.github.matheusalencar23.schoolsync.exceptions.ResourceNotFoundException;
import io.github.matheusalencar23.schoolsync.model.User;
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
        // String password = passwordField.getText();

        try {
            UserDao userDao = new UserDaoImpl();
            User user = userDao.findByUsername(username);

            if (user.getRole().equals("STUDENT")) {
                SceneManager.switchTo("SchollSync | " + user.getUsername(), "view/student-dashboard.fxml");
            }
        } catch (ResourceNotFoundException e) {
            System.out.println("erro");
            errorLabel.setText("Credenciais inválidas");
        }
    }
}
