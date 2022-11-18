package app.morax.View;

import app.morax.Model.Base.HourModel;
import app.morax.Model.Base.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DayView extends VBox {

    Label dateLabel;

    ObservableList<Task> taskObservableList = FXCollections.observableArrayList();

    DayView(String date, String month, ArrayList<Task> tasks) {
        this.dateLabel = new Label(" " + month + " " + date + "                                                                        ");
        this.dateLabel.setPadding(new Insets(2, 2, 2, 2));
        this.getChildren().add(dateLabel);
        dateLabel.setStyle("-fx-background-color: rgba(255,183,0,0.38);" +
                "-fx-text-fill: rgba(217,142,4,0.89)");
        for (Task t : tasks) {
            Label category;
            Label time;
            HourModel hm = new HourModel(String.valueOf(t.getDate().getHour()), null);
            time = new Label("   • " + hm.getHour12()  + ":" + t.getDate().format(DateTimeFormatter.ofPattern("mm")) + " " +  hm.getAMPM());
            time.setStyle("-fx-font-size: 12;" + "-fx-text-fill: Black;" + "-fx-font-family: Arial;");
            time.setAlignment(Pos.CENTER_LEFT);
            Label task = new Label(t.getName());
            HBox taskHB = new HBox(time, task);
            taskHB.setSpacing(15);
            taskHB.setAlignment(Pos.CENTER_LEFT);
            this.getChildren().add(taskHB);
        }
        this.setSpacing(10);
    }

    public void setOBS(ObservableList<Task> tasksOBS) {
        this.taskObservableList = tasksOBS;
    }

    public ObservableList<Task> getOBS() {
        return taskObservableList;
    }

    public void setDateLabel(String dateLabel) {
        this.dateLabel.setText(dateLabel);
    }

    public String getDateLabel() {
        return dateLabel.getText();
    }

}
