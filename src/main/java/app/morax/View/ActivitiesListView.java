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

public class ActivitiesListView extends StackPane implements ModelListener {
    ObservableList<String> sortOptions = FXCollections.observableArrayList("Name", "Location", "Date", "Priority");
    private ObservableList<Task> activitiesListObs;
    private ListView<Task> activitiesListView;
    private ComboBox<String> sortC = new ComboBox<>();

    private MainModel model;

    public ActivitiesListView() {
        activitiesListView = new ListView<>();
        activitiesListObs = FXCollections.observableArrayList();
        activitiesListView.setPrefHeight(10000);
        Label title2 = new Label("All Activities");

        // the HBox that has the title and sorting drop-down
        sortC.setItems(sortOptions);
        sortC.setValue("Name");
        HBox topH = new HBox(title2, sortC);
        topH.setMinWidth(50);
        topH.setAlignment(Pos.CENTER_LEFT);
        topH.setSpacing(45);
        topH.setPadding(new Insets(2, 2, 0, 2));

        // the main vbox
        VBox mainVBox = new VBox(topH, activitiesListView);
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setSpacing(5);
        mainVBox.setBorder(Border.stroke(Paint.valueOf("#0d2a0d")));
        mainVBox.setPadding(new Insets(2, 2, 2, 2));
        mainVBox.setStyle("-fx-background-color: #ffbe47");
        this.getChildren().add(mainVBox);
    }

    @Override
    public void update() {
        activitiesListObs.clear();
        //ask for a sorted list from the model
        activitiesListObs.addAll(model.sortTaskList(sortC.getSelectionModel().getSelectedIndex()));
        this.activitiesListView.setItems(activitiesListObs);
    }

    @Override
    public void setModel(MainModel model) {
        this.model = model;
    }

    public void associateHandler(Controller controller) {
        this.sortC.setOnAction(controller::handleSort);
    }
}
