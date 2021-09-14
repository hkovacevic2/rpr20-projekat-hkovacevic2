package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.UserDAO;
import ba.unsa.etf.rpr.models.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class PopupController {
    private UserDAO dao;
    public TextField fldName;
    public TextField fldSurname;
    public TextField fldNumber;
    public TextField fldUsername;
    public TextField fldPw;
    private ArrayList<TextField> fields = new ArrayList<>();

    public PopupController(UserDAO dao) {
        this.dao = dao;
    }

    @FXML
    public void initialize() {
        fields.addAll(Arrays.asList(fldName, fldSurname, fldNumber, fldUsername, fldPw));
        fields.forEach(f -> f.focusedProperty().addListener((a, b, c) -> f.getStyleClass().removeAll("poljeNijeIspravno")));
    }

    public void addAction(ActionEvent actionEvent) {
        AtomicInteger error = new AtomicInteger();
        fields.forEach(f -> {
            if(f.getText().isBlank()) {
                f.getStyleClass().add("poljeNijeIspravno");
                error.set(error.get() + 1);
            }});
        try {
            Long.parseLong(fldNumber.getText());
        }catch (NumberFormatException e) {
            fldNumber.getStyleClass().add("poljeNijeIspravno");
            error.set(error.get() + 1);
        }
        if(error.get() == 0) {
            dao.addNewEmployee(new Employee(0, fldUsername.getText(), fldPw.getText(), false,fldName.getText(), fldSurname.getText(), fldNumber.getText()));
            ((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
        }
    }

    public void cancelAction(ActionEvent actionEvent) {
        ((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
    }
}
