package com.cmpt370.cmpt370;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class MainUI extends StackPane {

    MainUI() {
        MainView primaryView = new MainView();
        MainController primaryController = new MainController();
        AppModel primaryModel = new AppModel();

        primaryView.setModel(primaryModel);
        primaryView.associateHandler(primaryController);
        primaryController.setModel(primaryModel);

        this.getChildren().add(primaryView);
        this.setAlignment(Pos.CENTER);
    }



}
