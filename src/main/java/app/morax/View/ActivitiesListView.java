package app.morax.View;

import app.morax.Controller.Controller;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.MainModel;
import app.morax.Model.Base.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ActivitiesListView extends StackPane implements ModelListener {
    ObservableList<String> sortOptions = FXCollections.observableArrayList("Name", "Location", "Date", "Priority");
    private final ObservableList<HBox> activitiesListObs;
    private final ListView<HBox> activitiesListView;
    private final ComboBox<String> sortC = new ComboBox<>();

    private MainModel model;

    public ActivitiesListView() {
        // initializing
        activitiesListView = new ListView<>();
        activitiesListObs = FXCollections.observableArrayList();
        activitiesListView.setPrefHeight(10000);
        activitiesListView.setItems(activitiesListObs);

        // the HBox that has the title and sorting drop-down
        Label title2 = new Label("All Activities");
        sortC.setItems(sortOptions);
        sortC.setValue("Name");
        HBox topH = new HBox(title2, sortC);
        topH.setMinWidth(50);
        topH.setAlignment(Pos.CENTER_LEFT);
        topH.setSpacing(45);
        topH.setPadding(new Insets(2, 2, 0, 2));

        // The List View


        // the main vbox
        VBox mainVBox = new VBox(topH, activitiesListView);
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setSpacing(5);
        mainVBox.setBorder(Border.stroke(Paint.valueOf("#0d2a0d")));
        mainVBox.setPadding(new Insets(2, 2, 2, 2));
        mainVBox.setStyle("-fx-background-color: rgba(236, 189, 119, 0.84)");
        this.getChildren().add(mainVBox);
    }

    @Override
    public void update() {
        activitiesListObs.clear();

        // sort the model's task list accordingly
        switch (sortC.getSelectionModel().getSelectedIndex()) {
            case 0 -> model.sortTaskList(0);
            case 1 -> model.sortTaskList(1);
            case 2 -> model.sortTaskList(2);
            case 3 -> model.sortTaskList(3);
        }

        for (Task t : model.getTasks()) {
            String month = MainUI.getMonth(Integer.parseInt(t.getDate().format(DateTimeFormatter.ofPattern("MM"))));
            Label taskN = new Label(t.getName());
            Label taskDT = new Label("    " + month.substring(0, 3) + t.getDate().format(DateTimeFormatter.ofPattern(" dd, HH:mm ")));
            taskDT.setStyle("-fx-font-size: 12;" + "-fx-text-fill: Black;" + "-fx-font-family: Arial;");
            HBox taskHBox = new HBox(taskN, taskDT);
            taskHBox.setAlignment(Pos.CENTER_LEFT);
            activitiesListObs.add(taskHBox);
        }

    }

    @Override
    public void setModel(MainModel model) {
        this.model = model;
    }

    public void associateHandler(Controller controller) {
        this.sortC.setOnAction(controller::handleSort);
    }
}
