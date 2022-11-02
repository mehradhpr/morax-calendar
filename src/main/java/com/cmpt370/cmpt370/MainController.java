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



        Stage newActivityStage = new Stage();
        newActivityStage.setScene(new Scene(thisView, 200, 110));
        newActivityStage.show();
    }

    public void handleNewActivityB(ActionEvent e) {
        NewActivityView thisView = new NewActivityView();
        NewActivityViewController thisController = new NewActivityViewController();
        thisView.associateHandler(thisController);
        thisController.setView(thisView);



        Stage newActivityStage = new Stage();
        newActivityStage.setScene(new Scene(thisView, 200, 110));
        newActivityStage.show();

    }


}
