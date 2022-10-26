package com.cmpt370.cmpt370;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class AppView extends StackPane implements ModelListener{

    AppModel model;

    ListView<String> scheduleList;

    ListView<String> activitiesList;


    ObservableList<String> calendarO = FXCollections.observableArrayList();

    Button newActivityB;

    Button scheduleB;

    Button sortB;

    AppView() {

        scheduleB = new Button("Schedule an Activity");
        scheduleList = new ListView<>();
        Label title1 = new Label("Schedule");
        VBox leftVBox = new VBox(title1, scheduleList, scheduleB);
        leftVBox.setAlignment(Pos.TOP_CENTER);
        leftVBox.setSpacing(5);


        sortB = new Button("Sort");
        newActivityB = new Button("New Activity");
        activitiesList = new ListView<>();
        Label title2 = new Label("All Activities");
        HBox buttonVBox = new HBox(newActivityB, sortB);
        buttonVBox.setAlignment(Pos.TOP_CENTER);
        buttonVBox.setSpacing(5);
        VBox rightVBox = new VBox(title2, activitiesList, buttonVBox);
        rightVBox.setAlignment(Pos.TOP_CENTER);
        rightVBox.setSpacing(5);
        HBox mainHBox = new HBox(leftVBox, rightVBox);
        mainHBox.setMaxWidth(500);
        mainHBox.setSpacing(10);
        mainHBox.setPadding(new Insets(5, 5, 5, 5));
        this.getChildren().add(mainHBox);

    }

    @Override
    public void update() {

    }
    public void setModel(AppModel model) {
        this.model = model;
    }

    @Override
    public void associateHandler(Controller controller) {
        this.newActivityB.setOnAction(((AppController) controller)::handleNewActivityB);
        this.scheduleB.setOnAction(((AppController) controller)::handleScheduleB);
    }
}
