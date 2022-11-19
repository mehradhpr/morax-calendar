package app.morax.View;

import app.morax.Controller.Controller;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.HourModel;
import app.morax.Model.Base.MainModel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MenuView extends StackPane implements ModelListener {

    MainModel model;
    Button newActivityB;
    Button meetB;
    Button chartViewB;
    Button categoriesB;
    Button setting;
    Controller controller;

    public MenuView() {

        // the menu anchorPane
        AnchorPane menuBar = new AnchorPane();
        menuBar.setStyle("-fx-background-color: rgba(255,145,0,0.7)");


        // Left side of the menu
        categoriesB = new Button("Categories");
        meetB = new Button("Meet");
        chartViewB = new Button("View Progress");
        chartViewB.setStyle("-fx-background-color: linear-gradient(#d38836, Yellow)");
        newActivityB = new Button("New Activity");
        HBox leftMenu = new HBox(newActivityB, categoriesB, meetB, chartViewB);
        leftMenu.setSpacing(3);

        // Right side of the menu
        setting = new Button("Setting");
        HBox rightMenu = new HBox(setting);

        // Current date display in the menu
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);
        HourModel HM = new HourModel(now.format(DateTimeFormatter.ofPattern("HH")), null);
        Label date = new Label(MainUI.getMonth(Integer.parseInt(currentTime.substring(5, 7))).substring(0, 3) +
                " "  + currentTime.substring(8, 10) + ", " +
                HM.getHour12() +
                currentTime.substring(13, 16) + " " + HM.getAMPM());

        // anchoring the right side
        AnchorPane.setTopAnchor(rightMenu, 2.0);
        AnchorPane.setRightAnchor(rightMenu, 2.0);

        // anchoring the left side
        AnchorPane.setLeftAnchor(leftMenu, 2.0);
        AnchorPane.setTopAnchor(leftMenu, 2.0);

        // anchoring date
        AnchorPane.setTopAnchor(date, 2.0);
        AnchorPane.setLeftAnchor(date, 400.0);

        // setting up anchorPane
        menuBar.setMinHeight(33);
        menuBar.setPadding(new Insets(2, 2, 2, 2));
        menuBar.getChildren().addAll(leftMenu, date, rightMenu);
        this.getChildren().add(menuBar);
        this.update();
    }

    @Override
    public void update() {}

    @Override
    public void setModel(MainModel model) {
        this.model = model;
    }

    public void associateHandler(Controller controller) {
        this.newActivityB.setOnAction(controller::handleNewActivityB);
        this.categoriesB.setOnAction(controller::handleCategoriesB);
        this.chartViewB.setOnAction(controller::handleSwitchView);
        this.meetB.setOnAction(controller::handleMeetB);
        this.setting.setOnAction(controller::handleSettingB);
    }
}
