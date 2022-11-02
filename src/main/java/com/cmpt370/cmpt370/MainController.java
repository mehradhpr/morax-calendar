package com.cmpt370.cmpt370;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController implements Controller{
    private AppModel model;
    public void setModel(AppModel model) {
        this.model = model;
    }

    @Override
    public void setView(ModelListener view) {

    }

    public void handleScheduleB(ActionEvent e) {
        ScheduleView thisView = new ScheduleView();
        ScheduleController thisController = new ScheduleController();
        thisView.associateHandler(thisController);
        thisController.setView(thisView);



        Stage scheduleStage = new Stage();
        scheduleStage.setScene(new Scene(thisView, 200, 110));
        scheduleStage.getScene().getStylesheets().add("secondarySkin.css");
        scheduleStage.show();
    }

    public void handleNewActivityB(ActionEvent e) {
        NewActivityView thisView = new NewActivityView();
        NewActivityViewController thisController = new NewActivityViewController();
        thisView.associateHandler(thisController);
        thisController.setView(thisView);



        Stage newActivityStage = new Stage();
        newActivityStage.setScene(new Scene(thisView, 225, 220));
        newActivityStage.getScene().getStylesheets().add("secondarySkin.css");
        newActivityStage.show();

    }

    public void handleCategoriesB(ActionEvent e) {
        CategoriesView thisView = new CategoriesView();

        Stage categoriesStage = new Stage();
        categoriesStage.setScene(new Scene(thisView, 350, 300));
        categoriesStage.getScene().getStylesheets().add("secondarySkin.css");
        categoriesStage.show();
    }

    public void handleAddCategory(ActionEvent e) {
        AddCategoryView thisView = new AddCategoryView();

        Stage addCategoriesStage = new Stage();
        addCategoriesStage.setScene(new Scene(thisView, 350, 300));
        addCategoriesStage.getScene().getStylesheets().add("secondarySkin.css");
        addCategoriesStage.show();
    }


}
