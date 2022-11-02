package com.cmpt370.cmpt370;

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

    private TextField titleText;

    private TextField dateText;

    private Button addCategoryB;

    private Button removeCategoryB;

    private Button cancelB;

    CategoriesView() {
        Label title1 = new Label("All Categories");

        ListView<String> categoriesL = new ListView<>();




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

    }

    @Override
    public void setModel(AppModel model) {

    }

    @Override
    public void associateHandler(Controller controller) {
        addCategoryB.setOnAction(((MainController) controller)::handleAddCategory);
    }
}
