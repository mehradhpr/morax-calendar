package app.morax.View;

import app.morax.Controller.Controller;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.MainModel;
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

    BorderPane mainPane;
    ChartView chartView;
    CompareView compareView;

    public MainUI(MainModel model) {

        // creating the MVC objects
        Controller controller = new Controller();
        activitiesListView = new ActivitiesListView();
        activitiesListView.setPrefWidth(270);
        scheduleDisplayView = new ScheduleDisplayView();

        //create a stackPane, so we can stack the views and switch between them
        StackPane switchViews = new StackPane();

        scheduleDisplayView = new ScheduleDisplayView();
        chartView = new ChartView();
        chartView.setVisible(false);

        switchViews.getChildren().addAll(chartView, scheduleDisplayView);

        compareView = new CompareView();
        menuBarView = new MenuView();

        // linking the MVC objects
        controller.setModel(model);
        compareView.setModel(model);
        scheduleDisplayView.setModel(model);
        chartView.setModel(model);
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
        model.addSubscriber(chartView);
        model.addSubscriber(compareView);
        model.addSubscriber(this);

        controller.setView(this);

        // setting up the borderPane
        mainPane = new BorderPane();
        mainPane.setCenter(switchViews);
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

    public void switchView() {
        chartView.setVisible(!chartView.isVisible());
        scheduleDisplayView.setVisible(!chartView.isVisible());
        if (chartView.isVisible()) this.menuBarView.chartViewB.setText("View Calendar");
        else this.menuBarView.chartViewB.setText("View Progress");
    }
}
