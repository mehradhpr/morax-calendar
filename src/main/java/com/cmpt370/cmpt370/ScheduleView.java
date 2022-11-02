package com.cmpt370.cmpt370;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ScheduleView extends StackPane implements ModelListener {

    private TextField titleText;

    private TextField dateText;

    private Button button;

    ScheduleView() {
        Label title1 = new Label("Schedule an Activity");


        Label title2 = new Label("Title: ");
        titleText = new TextField("title");
        HBox titleHBox = new HBox(title2, titleText);
        titleHBox.setAlignment(Pos.CENTER);

        Label title3 = new Label("Date: ");
        dateText = new TextField("dd/mm/yyyy");
        HBox dateHBox = new HBox(title3, dateText);
        dateHBox.setAlignment(Pos.CENTER);

        button = new Button("Add");

        VBox mainVBox = new VBox(title1, titleHBox, dateHBox, button);
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setSpacing(5);
        this.getChildren().add(mainVBox);
    }


    @Override
    public void update() {

    }

    @Override
    public void setModel(AppModel model) {

    }

    @Override
    public void associateHandler(Controller controller) {

    }
}
