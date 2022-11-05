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


public class MainView extends StackPane implements ModelListener {

    MainModel model;

    ListView<HBox> scheduleList;

    ObservableList<HBox> scheduleObs;

    ListView<Task> activitiesList;

    Button newActivityB;

    Button scheduleB;

    Button categoriesB;

    Button sortB;

    Button setting;

    public MainView() {

        scheduleB = new Button("Schedule an Activity");

        scheduleList = new ListView<>();
        scheduleList.setPrefHeight(10000);
        VBox centreVBox = new VBox(scheduleList, scheduleB);
        centreVBox.setAlignment(Pos.TOP_CENTER);
        centreVBox.setSpacing(5);
        centreVBox.setPadding(new Insets(2, 2, 2, 2));




        scheduleObs = FXCollections.observableArrayList();
        HBox thisH = new HBox();

        scheduleObs.add(thisH);
        scheduleList.setItems(this.scheduleObs);




        activitiesList = new ListView<>();
        activitiesList.setPrefHeight(10000);
        Label title2 = new Label("All Activities");
        ComboBox<String> sortC = new ComboBox<>();
        HBox topH = new HBox(title2, sortC);
        topH.setMinWidth(50);
        topH.setAlignment(Pos.CENTER_RIGHT);
        topH.setSpacing(45);

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
        Label date = new Label("Oct 12, 2022");
        AnchorPane.setTopAnchor(date, 2.0);
        AnchorPane.setLeftAnchor(date, 400.0);
        menuBar.getChildren().addAll(menu1, date);

        HBox status = new HBox();

        VBox tools = new VBox();




        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(centreVBox);
        mainPane.setRight(rightVBox);
        mainPane.setTop(menuBar);
        mainPane.setBorder(Border.stroke(Paint.valueOf("#0d2a0d")));
        //mainPane.setPadding(new Insets(5, 5, 5, 5));
        this.getChildren().add(mainPane);

    }

    public void addNewDayHBox(String date, ObservableList<Task> tasks) {
        DayHBox newDHB = new DayHBox();
        newDHB.setDate(date);
        newDHB.setOBS(tasks);
    }

    public void getDayHBox(HBox dayHBox) {

    }

    @Override
    public void update() {
        ObservableList<Task> temp = FXCollections.observableArrayList();
        temp.addAll(model.getTasks());

        this.activitiesList.setItems(temp);
    }
    public void setModel(MainModel model) {
        this.model = model;
    }


    @Override
    public void associateHandler(Controller controller) {
        this.newActivityB.setOnAction(((MainController) controller)::handleNewActivityB);
        this.scheduleB.setOnAction(((MainController) controller)::handleScheduleB);
        this.categoriesB.setOnAction(((MainController) controller)::handleCategoriesB);
    }
}
