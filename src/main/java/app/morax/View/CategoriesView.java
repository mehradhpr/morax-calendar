package app.morax.View;

import app.morax.Controller.CategoryController;
import app.morax.Interface.Controller;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.Category;
import app.morax.Model.Base.MainModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CategoriesView extends StackPane implements ModelListener {

    private MainModel model;

    private TextField titleText;

    private TextField dateText;

    private Button addCategoryB;

    private Button removeCategoryB;

    private Button cancelB;

    ListView<Category> categoriesL;

    public CategoriesView() {
        Label title1 = new Label("All Categories");

        categoriesL = new ListView<>();

        VBox leftVBox = new VBox(title1, categoriesL);
        leftVBox.setAlignment(Pos.CENTER);
        leftVBox.setSpacing(5);


        addCategoryB = new Button("Add Category");
        removeCategoryB = new Button("Remove category");
        cancelB = new Button("Cancel");
        HBox buttonsHBox = new HBox(addCategoryB, removeCategoryB, cancelB);
        buttonsHBox.setSpacing(5);
        buttonsHBox.setAlignment(Pos.CENTER);

        VBox mainVBox = new VBox(leftVBox, buttonsHBox);
        mainVBox.setPadding(new Insets(10, 10, 10, 10));
        mainVBox.setSpacing(5);
        mainVBox.setAlignment(Pos.CENTER);
        this.getChildren().add(mainVBox);
    }


    @Override
    public void update() {
        ObservableList<Category> categories = FXCollections.observableArrayList();
        for (Category c:model.getCategories()){
            categories.add(c);
        }

        this.categoriesL.setItems(categories);
    }

    @Override
    public void setModel(MainModel model) {
        this.model = model;
    }

    @Override
    public void associateHandler(Controller controller) {
        addCategoryB.setOnAction(((CategoryController) controller)::handleAddCategory);
        removeCategoryB.setOnAction(((CategoryController) controller)::handleRemoveCategory);
    }

    public Category getSelection(){
        return this.categoriesL.getSelectionModel().getSelectedItem();
    }
}
