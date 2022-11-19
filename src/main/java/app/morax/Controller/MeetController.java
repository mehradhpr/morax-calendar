package app.morax.Controller;

import app.morax.Model.Base.MainModel;
import app.morax.View.*;
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

    public void handleCancelB(ActionEvent actionEvent) {
        this.stage.close();
    }

    public void handleMeetB(ActionEvent actionEvent) {
        MeetingDateView meetingDateView = new MeetingDateView(this.view.getSelection().getName());
        MeetingDateController meetingDateController = new MeetingDateController();

        //link the new view and its controller
        meetingDateView.associateHandler(meetingDateController);
        meetingDateController.setView(meetingDateView);

        //link the model and controller
        meetingDateView.setModel(model);
        meetingDateController.setModel(model);
        model.addSubscriber(meetingDateView);

        //open a new window
        Stage meetingStage = new Stage();
        meetingStage.setScene(new Scene(meetingDateView, 220, 150));
        meetingStage.getScene().getStylesheets().add("secondarySkin.css");
        meetingStage.show();
    }
}



