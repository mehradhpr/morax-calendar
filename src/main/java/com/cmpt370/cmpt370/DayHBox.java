package com.cmpt370.cmpt370;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import com.cmpt370.cmpt370.Base.Task;

public class DayHBox extends HBox {

    Label date;

    ListView<Task> taskListView;

    ObservableList<Task> taskObservableList;

    DayHBox() {
        this.getChildren().addAll(date, taskListView);
    }

    public void setOBS(ObservableList<Task> tasksOBS) {

    }

    public ObservableList<Task> getOBS() {
        return null;
    }

    public void setDate(String date) {

    }

    public String getDate() {
        return null;
    }




}
