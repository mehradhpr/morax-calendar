package app.morax.Controller;

import app.morax.Model.Base.MainModel;
import app.morax.Model.Base.Task;
import app.morax.View.MeetingDateView;
import javafx.event.ActionEvent;

import java.time.LocalDateTime;

public class MeetingDateController {

    private MeetingDateView view;

    private MainModel model;


    public void setView(MeetingDateView meetingDateView) {
        this.view = meetingDateView;
    }

    public void setModel(MainModel model) {
        this.model = model;
    }

    public void handleSetB(ActionEvent actionEvent) {
        int PMAdditional = 0;
        if (this.view.PmAmC.getValue().equals("PM")) {
            PMAdditional += 12;
        }

        LocalDateTime thisT = LocalDateTime.of(Integer.parseInt(this.view.DT.getEditor().getText(0, 4)), Integer.parseInt(this.view.DT.getEditor().getText(5, 7)) ,
                Integer.parseInt(this.view.DT.getEditor().getText(8, 10)),
                Integer.parseInt(this.view.getTimeText().getText(0, 2)) + PMAdditional, Integer.parseInt(this.view.getTimeText().getText(3, 5)));


        Task meeting = new Task(thisT, model.getPeople().get(view.getPersonName()));
        model.addTask(meeting);
    }

    public void handleCancelB(ActionEvent actionEvent) {
    }
}
