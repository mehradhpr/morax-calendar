package app.morax.Controller;

import app.morax.Model.Base.MainModel;
import app.morax.View.CategoriesView;
import app.morax.View.NewActivityView;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    private MainModel model;
    public void setModel(MainModel model) {
        this.model = model;
    }

    public void handleNewActivityB(ActionEvent ignored) {
        // creating the components
        NewActivityView newActivityView = new NewActivityView();
        NewActivityController newActivityController = new NewActivityController();


        // linking components
        newActivityView.setModel(model);
        newActivityView.associateHandler(newActivityController);
        newActivityController.setView(newActivityView);
        newActivityController.setModel(model);
        model.addSubscriber(newActivityView);

        // Starting new window
        Stage newActivityStage = new Stage();
        newActivityStage.setScene(new Scene(newActivityView, 250, 270));
        newActivityStage.getScene().getStylesheets().add("secondarySkin.css");
        newActivityStage.show();
    }

    public void handleCategoriesB(ActionEvent ignored) {
        CategoriesView thisView = new CategoriesView();
        CategoryController thisController = new CategoryController();

        //linking everything together
        thisController.setModel(model);
        thisController.setView(thisView);

        thisView.setModel(model);
        thisView.associateHandler(thisController);

        model.addSubscriber(thisView);
        thisView.update();

        //opening the new window
        Stage categoriesStage = new Stage();
        categoriesStage.setScene(new Scene(thisView, 350, 300));
        categoriesStage.getScene().getStylesheets().add("secondarySkin.css");
        categoriesStage.show();
    }

    //Handles the sort parameters changing for the activities view
    public void handleSort(ActionEvent ignored){
        if (model.getTasks().size() != 0) {
            model.updateSubscribers();
        }
    }

    public void handleSettingB(ActionEvent actionEvent) {
    }
}
