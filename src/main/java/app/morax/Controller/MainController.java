package app.morax.Controller;

import app.morax.Interface.Controller;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.MainModel;
import app.morax.View.CategoriesView;
import app.morax.View.NewActivityView;
import app.morax.View.ScheduleView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController implements Controller {
    private MainModel model;
    public void setModel(MainModel model) {
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
        thisView.setModel(model);
        NewActivityViewController thisController = new NewActivityViewController();

        //linking components
        thisView.associateHandler(thisController);
        thisController.setView(thisView);
        thisView.update();


        thisController.setModel(model);
        thisView.setModel(model);

        //new window
        Stage newActivityStage = new Stage();
        newActivityStage.setScene(new Scene(thisView, 250, 270));
        newActivityStage.getScene().getStylesheets().add("secondarySkin.css");
        newActivityStage.show();

    }

    public void handleCategoriesB(ActionEvent e) {
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
}
