package app.morax.Controller;

import app.morax.Interface.Controller;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.Day;
import app.morax.Model.Base.MainModel;
import app.morax.Model.Base.Task;
import app.morax.View.NewActivityView;
import javafx.event.ActionEvent;

public class NewActivityViewController implements Controller {

    private MainModel model;

    private NewActivityView view;

    public void setModel(MainModel model) {
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
        Task newTask = new Task();
        newTask.setName(this.view.getTitleText().getText());

        for (Day day : this.model.getDays()) {
            if (this.view.getDateText().getText(0, 4).equals(day.getDay() + "/" + day.getMonth())) {
                newTask.setDay(day);
            }
        }

        if (newTask.getDay() == null) {
            Day newDay = new Day();
            newDay.setDay(this.view.getDateText().getText(0, 1));
            newDay.setMonth(this.view.getDateText().getText(3, 4));
            newDay.setDay(this.view.getDateText().getText(6, 9));
            newTask.setDay(newDay);
        }
    }
}
