package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.models.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {
    private UserDAO dao;
    public TextField fldUsername;
    public PasswordField fldPassword;
    public Button btnLogin;

    public LoginController() {
    }

    public LoginController(UserDAO dao) {
        this.dao = dao;
    }

    @FXML
    public void initialize() {
        fldUsername.focusedProperty().addListener((a, b, c) -> fldUsername.getStyleClass().removeAll("poljeNijeIspravno"));
        fldPassword.focusedProperty().addListener((a, b, c) -> fldPassword.getStyleClass().removeAll("poljeNijeIspravno"));
    }

    public void loginAction(ActionEvent actionEvent) {
        if (fldUsername.getText().isBlank()) {
            fldUsername.getStyleClass().add("poljeNijeIspravno");
        }
        if(fldPassword.getText().isBlank()) {
            fldPassword.getStyleClass().add("poljeNijeIspravno");
        }
        User user = dao.getUser(fldUsername.getText(), fldPassword.getText());
        if(user == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText("Careful with the next step!");

            alert.showAndWait();
        }
    }
}
