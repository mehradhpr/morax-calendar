package app.morax;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        MainUI mainUI = new MainUI();
        Scene mainScene = new Scene(mainUI, 800, 450);
        mainScene.getStylesheets().add("primarySkin.css");
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Calendar");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}