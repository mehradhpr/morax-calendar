package app.morax.Controller;

import app.morax.Interface.Controller;
import app.morax.Interface.ModelListener;
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
        Task newTask = new Task(this.view.getTitleText().getText());
        this.model.addTask(newTask);
        model.updateSubscribers();
    }
}
