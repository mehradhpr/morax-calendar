package com.cmpt370.cmpt370;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

public class MainUI extends StackPane {

    MainUI() {
        AppView primaryView = new AppView();
        AppController primaryController = new AppController();
        AppModel primaryModel = new AppModel();

        primaryView.setModel(primaryModel);
        primaryView.associateHandler(primaryController);
        primaryController.setModel(primaryModel);

        this.getChildren().add(primaryView);
        this.setAlignment(Pos.CENTER);
    }



}
