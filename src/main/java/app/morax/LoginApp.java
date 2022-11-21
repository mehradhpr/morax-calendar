package app.morax;

import app.morax.View.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(Stage stage){
        LoginView root = new LoginView(stage);

        Scene mainScene = new Scene(root, 1000, 450);
        mainScene.getStylesheets().add("primarySkin.css");
        stage.setScene(mainScene);
        stage.setTitle("Login");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
