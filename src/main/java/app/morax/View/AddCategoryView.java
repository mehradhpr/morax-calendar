package app.morax.View;

import app.morax.Controller.NewCategoryController;
import app.morax.Interface.Controller;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.MainModel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class AddCategoryView extends StackPane implements ModelListener {


    TextArea field1;
    TextArea field2;
    TextArea t;
    Button addB;


    public AddCategoryView() {
        Label label1 = new Label("Add a new category");

        Label label2 = new Label("Category Name: ");
        field1 = new TextArea();
        VBox VBox1 = new VBox(label2, field1);


        Label label3 = new Label("Weekly Time Limit: ");
        field2 = new TextArea();
        Label label4 = new Label("Hours");
        VBox VBox2 = new VBox(label3, field2, label4);

        Label label5 = new Label("Category Color: ");

        Label label6 = new Label("Category Notes: ");
        t = new TextArea();
        t.setMaxWidth(150);
        HBox notesH = new HBox(label6, t);

        addB = new Button("Add");

        VBox mainVBox = new VBox(label1, VBox1, VBox2, label5, notesH, addB);
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
        return this.field1.getText();
    }
}
