package app.morax.Controller;

import app.morax.Model.Base.MainModel;
import app.morax.View.CategoriesView;
import app.morax.View.MeetView;
import app.morax.View.NewCategoryView;
import app.morax.View.NewPersonView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MeetController {
    private MainModel model;
    private MeetView view;
    private Stage stage;

    public void setModel(MainModel model) {
        this.model = model;
    }

    public void setView(MeetView view) {
        this.view = view;
    }

    //bring up the add Category page to enter information about the category
    public void handleAddPerson(ActionEvent e) {
        NewPersonView newPersonView = new NewPersonView();
        NewPersonController newPersonController = new NewPersonController();

        //link the new view and its controller
        newPersonView.associateHandler(newPersonController);
        newPersonController.setView(newPersonView);

        //link the model and controller
        newPersonController.setModel(model);
        model.addSubscriber(newPersonView);

        //open a new window
        Stage addCategoriesStage = new Stage();
        addCategoriesStage.setScene(new Scene(newPersonView, 270, 85));
        addCategoriesStage.getScene().getStylesheets().add("secondarySkin.css");
        addCategoriesStage.show();
    }

    //Remove the selected category
    public void handleRemovePerson(ActionEvent e){
        model.removePerson(view.getSelection());
    }

    public void setStage(Stage s) {
        this.stage = s;
    }

}



