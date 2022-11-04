package app.morax.View;

import app.morax.Model.Base.Day;
import app.morax.Model.Base.Task;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class DayHBox extends HBox {

    Label date;

    ListView<Task> taskListView;

    ObservableList<Task> taskObservableList;

    DayHBox() {
        this.getChildren().addAll(date, taskListView);
    }

    public void setOBS(ObservableList<Task> tasksOBS) {
        this.taskObservableList = tasksOBS;
    }

    public ObservableList<Task> getOBS() {
        return taskObservableList;
    }

    public void setDate(String date) {
        this.date.setText(date);
    }

    public String getDate() {
        return date.getText();
    }

}
