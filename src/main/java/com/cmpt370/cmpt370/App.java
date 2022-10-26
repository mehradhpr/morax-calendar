package com.cmpt370.cmpt370;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        MainUI mainUI = new MainUI();
        Scene mainScene = new Scene(mainUI, 700, 450);
        mainScene.getStylesheets().add("skin.css");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}