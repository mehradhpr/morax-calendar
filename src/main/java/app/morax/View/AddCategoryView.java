package app.morax.View;

import app.morax.Controller.NewCategoryController;
import app.morax.Interface.Controller;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.MainModel;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class AddCategoryView extends StackPane implements ModelListener {


    TextField nameText;
    TextField timeText;
    TextArea descriptionText;
    Button addB;


    public AddCategoryView() {
        Label label1 = new Label("Add a new category");

        Label label2 = new Label("Category Name: ");
        nameText = new TextField();
        HBox HBox1 = new HBox(label2, nameText);
        HBox1.setAlignment(Pos.TOP_LEFT);


        Label label3 = new Label("Weekly Time Limit: ");
        timeText = new TextField();
        timeText.setMaxWidth(50);
        Label label4 = new Label(" Hours");
        HBox HBox2 = new HBox(label3, timeText, label4);
        HBox2.setAlignment(Pos.TOP_LEFT);

        // Label label5 = new Label("Category Color: ");

        Label label6 = new Label("Category Notes: ");
        descriptionText = new TextArea();
        descriptionText.setMaxWidth(150);
        descriptionText.setMaxHeight(50);
        HBox notesH = new HBox(label6, descriptionText);
        notesH.setAlignment(Pos.TOP_LEFT);

        addB = new Button("Add");

        VBox mainVBox = new VBox(label1, HBox1, HBox2, notesH, addB);
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setSpacing(5);
        this.getChildren().add(mainVBox);
    }
    @Override
    public void update() {

    }

    @Override
    public void setModel(MainModel model) {

    }

    @Override
    public void associateHandler(Controller controller) {
        addB.setOnAction(((NewCategoryController) controller)::handleAddCategory);
    }

    public String getTitle(){
        return this.nameText.getText();
    }

    public String getTime(){
        return timeText.getText();
    }

    public String getDescription(){
        return descriptionText.getText();
    }
}
