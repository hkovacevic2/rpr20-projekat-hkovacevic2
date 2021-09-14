package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.UserDAO;
import ba.unsa.etf.rpr.UserNotFoundException;
import ba.unsa.etf.rpr.controllers.AdminController;
import ba.unsa.etf.rpr.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    private UserDAO dao;
    public TextField fldUsername;
    public PasswordField fldPassword;
    public Button btnLogin;

    public LoginController(UserDAO dao) {
        this.dao = dao;
    }

    @FXML
    public void initialize() {
        fldUsername.focusedProperty().addListener((a, b, c) -> fldUsername.getStyleClass().removeAll("poljeNijeIspravno"));
        fldPassword.focusedProperty().addListener((a, b, c) -> fldPassword.getStyleClass().removeAll("poljeNijeIspravno"));
    }

    public void loginAction(ActionEvent actionEvent) throws IOException {
        if (fldUsername.getText().isBlank()) {
            fldUsername.getStyleClass().add("poljeNijeIspravno");
        }
        if(fldPassword.getText().isBlank()) {
            fldPassword.getStyleClass().add("poljeNijeIspravno");
        }
        User user = null;
        try {
            user = dao.getUser(fldUsername.getText(), fldPassword.getText());
            dao.setSelectedUser(user);
            Stage panel = new Stage();
            FXMLLoader loader;
            if (user.isAdmin()) {
                loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/admin.fxml")));
                loader.setController(new AdminController(dao));
                panel.setTitle("Book Barbarian Bookstore");
                panel.setScene(new Scene(loader.load(), Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
                panel.getIcons().add(new Image("images/logo.png"));
                ((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
                panel.show();
            }
        } catch (UserNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(e.getMessage());
            alert.setContentText("Try again.");
            alert.showAndWait();
        }
    }
}
