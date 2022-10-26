package com.cmpt370.cmpt370;

import javafx.event.ActionEvent;

public class NewActivityViewController implements Controller {

    private AppModel model;

    private NewActivityView view;

    public void setModel(AppModel model) {
        this.model = model;
    }

    @Override
    public void setView(ModelListener view) {
        this.view = (NewActivityView) view;
    }

    public void handleTitleText(ActionEvent e) {
    }

    public void handleDateText(ActionEvent e) {
        System.out.println(this.view.getDateText().textProperty().get());
    }

    public void handleAddButton(ActionEvent e) {
        // Add Here
    }
}
