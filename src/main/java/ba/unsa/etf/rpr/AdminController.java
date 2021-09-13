package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.models.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
}
