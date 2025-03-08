package io.github.matheusalencar23.schoolsync.controller;

import java.net.URL;
import java.util.ResourceBundle;

import io.github.matheusalencar23.schoolsync.global.AppState;
import io.github.matheusalencar23.schoolsync.model.Person;
import io.github.matheusalencar23.schoolsync.model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class StudentDashboardController implements Initializable {

    @FXML
    private Label helloLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        User user = AppState.getInstance().getCurrentUser();
        Person person = user.getPerson();
        helloLabel.setText("Olá, " + person.getName());
    }

}
