package app.morax.View;

import app.morax.Controller.Controller;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.MainModel;
import app.morax.View.ActivitiesListView;
import app.morax.View.MenuView;
import app.morax.View.ScheduleDisplayView;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;

public class MainUI extends StackPane implements ModelListener {
    ScheduleDisplayView scheduleDisplayView;
    MenuView menuBarView;
    ActivitiesListView activitiesListView;
    MainModel mainModel;
    public MainUI() {

        // creating the MVC objects
        Controller controller = new Controller();
        MainModel model = new MainModel();
        scheduleDisplayView = new ScheduleDisplayView();
        activitiesListView = new ActivitiesListView();
        menuBarView = new MenuView();

        // linking the MVC objects
        controller.setModel(model);
        scheduleDisplayView.setModel(model);
        activitiesListView.setModel(model);
        menuBarView.setModel(model);
        this.setModel(model);
        scheduleDisplayView.associateHandler(controller);
        activitiesListView.associateHandler(controller);
        menuBarView.associateHandler(controller);
        this.associateHandler(controller);
        model.addSubscriber(scheduleDisplayView);
        model.addSubscriber(activitiesListView);
        model.addSubscriber(menuBarView);
        model.addSubscriber(this);

        // setting up the borderPane
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(scheduleDisplayView);
        mainPane.setRight(activitiesListView);
        mainPane.setTop(menuBarView);
        mainPane.setBorder(Border.stroke(Paint.valueOf("#0d2a0d")));
        this.getChildren().add(mainPane);
        this.setAlignment(Pos.CENTER);
    }


    @Override
    public void update() {

    }

    @Override
    public void setModel(MainModel model) {
        this.mainModel = model;
    }

    public void associateHandler(Controller controller) {

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
