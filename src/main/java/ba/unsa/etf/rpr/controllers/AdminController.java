package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.Main;
import ba.unsa.etf.rpr.UserDAO;
import ba.unsa.etf.rpr.models.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminController {
    public ListView<Employee> listRadnici;
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldBrtel;
    public TextField fldUsername;
    public TextField fldPassword;
    private UserDAO dao;
    
    
    public AdminController(UserDAO dao) {
        this.dao = dao;
    }
    
    @FXML
    public void initialize() {
        listRadnici.setItems(dao.getAllEmployees());
        listRadnici.getSelectionModel().selectedItemProperty().addListener((obs, oldE, newE) -> {
            dao.setSelectedUser(newE);
            if (oldE != null) {
                fldIme.textProperty().unbindBidirectional(oldE.nameProperty());
                fldPrezime.textProperty().unbindBidirectional(oldE.surnameProperty());
                fldUsername.textProperty().unbindBidirectional(oldE.usernameProperty());
                fldPassword.textProperty().unbindBidirectional(oldE.passwordProperty());
                fldBrtel.textProperty().unbindBidirectional(oldE.phoneNumberProperty());
            }
            if (newE == null) {
                fldIme.setText("");
                fldPrezime.setText("");
                fldBrtel.setText("");
                fldUsername.setText("");
                fldPassword.setText("");
            }
            else {
                fldIme.textProperty().bindBidirectional(newE.nameProperty());
                fldPrezime.textProperty().bindBidirectional(newE.surnameProperty());
                fldBrtel.textProperty().bindBidirectional(newE.phoneNumberProperty());
                fldUsername.textProperty().bindBidirectional(newE.usernameProperty());
                fldPassword.textProperty().bindBidirectional(newE.passwordProperty());
            }
            listRadnici.refresh();
        });
    }

    public void fireEmployee(ActionEvent actionEvent) {
        dao.fireEmployee();
        listRadnici.setItems(dao.getAllEmployees());
    }

    public void logoutAction(ActionEvent actionEvent) throws Exception {
        ((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
        Main.showLoginScreen(new Stage());
    }

    public void addEmployeeAction(ActionEvent actionEvent) {
        try {
            Stage popup = new Stage();
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/addemployee.fxml")));
            loader.setController(new PopupController(dao));
            popup.setTitle("BBB");
            popup.setScene(new Scene(loader.load(), Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
            popup.getIcons().add(new Image("images/logo.png"));
            popup.showAndWait();
            listRadnici.setItems(dao.getAllEmployees());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pregledTab(ActionEvent actionEvent) {

    }
}
