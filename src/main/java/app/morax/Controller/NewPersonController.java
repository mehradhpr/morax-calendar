package app.morax.Controller;

import app.morax.Model.Base.Category;
import app.morax.Model.Base.MainModel;
import app.morax.Model.Base.Person;
import app.morax.View.NewCategoryView;
import app.morax.View.NewPersonView;
import javafx.event.ActionEvent;

public class NewPersonController {

    private MainModel model;
    private NewPersonView view;

    public void setModel(MainModel model) {
        this.model = model;
    }

    public void setView(NewPersonView view) {
        this.view = view;
    }

    //add a new Person
    public void handleAddPerson(ActionEvent e){
        Person p = new Person(view.getTitle());

        model.addPerson(p);
    }
}
