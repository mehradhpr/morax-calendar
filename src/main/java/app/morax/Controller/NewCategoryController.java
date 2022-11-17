package app.morax.Controller;

import app.morax.Interface.ModelListener;
import app.morax.Model.Base.Category;
import app.morax.Model.Base.MainModel;
import app.morax.View.NewCategoryView;
import javafx.event.ActionEvent;

public class NewCategoryController {

    private MainModel model;
    private NewCategoryView view;

    public void setModel(MainModel model) {
        this.model = model;
    }

    public void setView(NewCategoryView view) {
        this.view = view;
    }

    //add a new Category
    public void handleAddCategory(ActionEvent e){
        Category c = new Category(view.getTitle(), 0, 12, Integer.parseInt(view.getTime()));
        model.addCategory(c);
    }
}
