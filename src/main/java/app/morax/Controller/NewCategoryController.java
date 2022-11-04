package app.morax.Controller;

import app.morax.Interface.Controller;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.Category;
import app.morax.Model.Base.MainModel;
import app.morax.View.AddCategoryView;
import javafx.event.ActionEvent;

public class NewCategoryController implements Controller {
    MainModel model;
    AddCategoryView view;

    @Override
    public void setModel(MainModel model) {
        this.model = model;
    }

    @Override
    public void setView(ModelListener view) {
        this.view = (AddCategoryView) view;
    }

    public void handleAddCategory(ActionEvent e){
        Category c = new Category(view.getTitle(), 0, 12, Integer.parseInt(view.getTime()));
        model.addCategory(c);
    }
}
