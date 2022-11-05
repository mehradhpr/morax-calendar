package app.morax.Controller;

import app.morax.Interface.Controller;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.MainModel;
import app.morax.View.AddCategoryView;
import app.morax.View.CategoriesView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CategoryController implements Controller {
    MainModel model;
    CategoriesView view;

    @Override
    public void setModel(MainModel model) {
        this.model = model;
    }

    @Override
    public void setView(ModelListener view) {
        this.view = (CategoriesView) view;
    }

    public void handleAddCategory(ActionEvent e) {
        AddCategoryView thisView = new AddCategoryView();
        NewCategoryController thisController = new NewCategoryController();
        thisView.associateHandler(thisController);
        thisController.setView(thisView);

        thisController.setModel(model);

        Stage addCategoriesStage = new Stage();
        addCategoriesStage.setScene(new Scene(thisView, 270, 170));
        addCategoriesStage.getScene().getStylesheets().add("secondarySkin.css");
        addCategoriesStage.show();
    }

    public void handleRemoveCategory(ActionEvent e){
        model.removeCategory(view.getSelection());
        model.updateSubscribers();
    }
}
