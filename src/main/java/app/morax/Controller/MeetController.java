package app.morax.Controller;

import app.morax.Model.Base.MainModel;
import app.morax.View.CategoriesView;
import app.morax.View.MeetView;
import app.morax.View.NewCategoryView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MeetController {
    private MainModel model;
    private MeetView view;

    public void setModel(MainModel model) {
        this.model = model;
    }

    public void setView(MeetView view) {
        this.view = view;
    }

    //bring up the add Category page to enter information about the category
    public void handleAddPerson(ActionEvent e) {
        NewCategoryView thisView = new NewCategoryView();
        NewCategoryController thisController = new NewCategoryController();

        //link the new view and its controller
        thisView.associateHandler(thisController);
        thisController.setView(thisView);

        //link the model and controller
        thisController.setModel(model);

        //open a new window
        Stage addCategoriesStage = new Stage();
        addCategoriesStage.setScene(new Scene(thisView, 270, 170));
        addCategoriesStage.getScene().getStylesheets().add("secondarySkin.css");
        addCategoriesStage.show();
    }

    //Remove the selected category
    public void handleRemovePerson(ActionEvent e){
        model.removePerson(view.getSelection());
    }
}

