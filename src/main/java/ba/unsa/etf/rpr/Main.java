package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class Main extends Application {

    public static void showLoginScreen(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(Main.class.getResource("/fxml/login.fxml")));
        loader.setController(new LoginController(UserDAO.getInstance()));
        Parent root = loader.load();
        stage.setTitle("BBB");
        stage.setScene(new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
        stage.getIcons().add(new Image("images/logo.png"));
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        showLoginScreen(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
