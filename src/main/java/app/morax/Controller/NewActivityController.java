package app.morax.Controller;

import app.morax.Model.Base.MainModel;
import app.morax.Model.Base.Task;
import app.morax.View.NewActivityView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class NewActivityController {

    private MainModel model;

    private NewActivityView view;
    private Stage stage;

    public void setModel(MainModel model) {
        this.model = model;
    }

    public void setView(NewActivityView view) {
        this.view = view;
    }
    public void handleTitleText(ActionEvent e) {
    }

    public void handleDateText(ActionEvent e) {
        System.out.println(this.view.getDateText().getText());
    }

    public void handleAddButton(ActionEvent e) {
        int PMAdditional = 0;
        if (this.view.PmAmC.getValue().equals("PM")) {
            PMAdditional += 12;
        }

        LocalDateTime thisT = LocalDateTime.of(Integer.parseInt(this.view.DT.getEditor().getText(0, 4)), Integer.parseInt(this.view.DT.getEditor().getText(5, 7)) ,
                Integer.parseInt(this.view.DT.getEditor().getText(8, 10)),
                Integer.parseInt(this.view.getTimeText().getText(0, 2)) + PMAdditional, Integer.parseInt(this.view.getTimeText().getText(3, 5)));


        Task newTask = new Task(this.view.getTitleText().getText(), this.view.getLocationText().getText(), thisT);
        newTask.setCategory(this.view.getCategoryC().getValue());
        this.model.addTask(newTask);
        this.stage.close();

    }

    public void handleSetTimeCheckBox(ActionEvent actionEvent) {
        if (view.setTimeCk.isSelected()) {
            view.timeText.setDisable(false);
            view.PmAmC.setDisable(false);
        }
        else {
            view.timeText.setDisable(true);
            view.PmAmC.setDisable(true);
        }
    }

    public void handleCancelB(ActionEvent actionEvent) {
        this.stage.close();
    }

    public void setStage(Stage newActivityStage) {
        this.stage = newActivityStage;
    }
}
