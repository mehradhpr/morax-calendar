package app.morax.View;

import app.morax.Controller.MainController;
import app.morax.Interface.Controller;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.MainModel;
import app.morax.Model.Base.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;


public class MainView extends StackPane implements ModelListener {

    MainModel model;

    ListView<VBox> scheduleList;

    ObservableList<VBox> scheduleObs = FXCollections.observableArrayList();

    ListView<Task> activitiesList;

    ObservableList<Task> activitiesObs;

    Button newActivityB;

    Button scheduleB;

    Button categoriesB;

    ObservableList<String> sortOptions = FXCollections.observableArrayList("Name", "Location", "Date");

    ComboBox<String> sortC;


    Button sortB;

    Button setting;

    Controller controller;
    ScheduleDisplayView SDV = new ScheduleDisplayView();

    public MainView() {


        activitiesObs = FXCollections.observableArrayList();

        scheduleB = new Button("Schedule an Activity");

        // The main schedule list part
        SDV.associateHandler(controller);

        activitiesList = new ListView<>();
        activitiesList.setPrefHeight(10000);
        Label title2 = new Label("All Activities");
        sortC = new ComboBox<>();
        sortC.setItems(sortOptions);
        sortC.setValue("Name");

        HBox topH = new HBox(title2, sortC);
        topH.setMinWidth(50);
        topH.setAlignment(Pos.CENTER_LEFT);
        topH.setSpacing(45);
        topH.setPadding(new Insets(2, 2, 0, 2));

        VBox rightVBox = new VBox(topH, activitiesList);
        rightVBox.setAlignment(Pos.TOP_CENTER);
        rightVBox.setSpacing(5);
        rightVBox.setBorder(Border.stroke(Paint.valueOf("#0d2a0d")));
        rightVBox.setPadding(new Insets(2, 2, 2, 2));
        rightVBox.setStyle("-fx-background-color: #ffbe47");

        AnchorPane menuBar = new AnchorPane();
        categoriesB = new Button("Categories");
        newActivityB = new Button("New Activity");
        HBox menu1 = new HBox(newActivityB, scheduleB, categoriesB);
        menu1.setSpacing(2);

        setting = new Button("Setting");
        HBox menu2 = new HBox(setting);
        AnchorPane.setTopAnchor(menu2, 2.0);
        AnchorPane.setRightAnchor(menu2, 2.0);
        menuBar.getChildren().add(menu2);
        menuBar.setStyle("-fx-background-color: #ff9100");
        AnchorPane.setLeftAnchor(menu1, 2.0);
        AnchorPane.setTopAnchor(menu1, 2.0);
        menuBar.setMinHeight(33);
        menuBar.setPadding(new Insets(2, 2, 2, 2));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);
        Label date = new Label(getMonth(Integer.parseInt(currentTime.substring(5, 7))).substring(0, 3) +
                                " "  + currentTime.substring(8, 10) + ", " +
                                currentTime.substring(0, 4) + "  " +
                                currentTime.substring(11, 16));
        AnchorPane.setTopAnchor(date, 2.0);
        AnchorPane.setLeftAnchor(date, 400.0);
        menuBar.getChildren().addAll(menu1, date);

        HBox status = new HBox();

        VBox tools = new VBox();




        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(SDV);
        mainPane.setRight(rightVBox);
        mainPane.setTop(menuBar);
        mainPane.setBorder(Border.stroke(Paint.valueOf("#0d2a0d")));
        //mainPane.setPadding(new Insets(5, 5, 5, 5));
        this.getChildren().add(mainPane);

    }

    public void getDayHBox(HBox dayHBox) {

    }

    @Override
    public void update() {
        activitiesObs.clear();
        //ask for a sorted list from the model
        activitiesObs.addAll(model.sortTaskList(sortC.getSelectionModel().getSelectedIndex()));
        this.activitiesList.setItems(activitiesObs);

    }
    public void setModel(MainModel model) {
        this.model = model;
        model.addSubscriber(SDV);
        SDV.setModel(this.model);


    }


    @Override
    public void associateHandler(Controller controller) {
        this.controller = controller;
        this.newActivityB.setOnAction(((MainController) controller)::handleNewActivityB);
        this.scheduleB.setOnAction(((MainController) controller)::handleScheduleB);
        this.categoriesB.setOnAction(((MainController) controller)::handleCategoriesB);
        this.sortC.setOnAction(((MainController) controller)::handleSort);
    }

    public static String getMonth(int i) {
        return switch (i) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> null;
        };
    }
}
