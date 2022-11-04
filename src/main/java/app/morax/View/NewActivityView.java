package app.morax.View;

import app.morax.Controller.NewActivityViewController;
import app.morax.Interface.Controller;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.MainModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class NewActivityView extends StackPane implements ModelListener {

    private TextField titleText;

    private TextField dateText;

    private TextField timeText;

    private Button button;

    public NewActivityView() {
        Label title1 = new Label("New Activity");


        Label title2 = new Label("Title: ");
        titleText = new TextField("title");
        HBox titleHBox = new HBox(title2, titleText);

        Label title3 = new Label("Date: ");
        dateText = new TextField("dd/mm/yyyy");
        HBox dateHBox = new HBox(title3, dateText);

        Label title4 = new Label("Set Time: ");
        CheckBox setTimeCk = new CheckBox();
        timeText = new TextField("10:30");
        timeText.setMaxWidth(50);
        ComboBox<String> PmAmC = new ComboBox<>();
        PmAmC.setMaxWidth(10);
        HBox setTimeH = new HBox(title4, setTimeCk, timeText, PmAmC);
        setTimeH.setSpacing(5);

        Label title5 = new Label("Category: ");
        ComboBox<String> categoryC = new ComboBox<>();
        HBox categoryH = new HBox(title5, categoryC);

        Label title6 = new Label("Notes: ");
        TextArea t = new TextArea();
        t.setMaxWidth(150);
        HBox notesH = new HBox(title6, t);

        button = new Button("Add");

        VBox mainVBox = new VBox(title1, titleHBox, dateHBox, setTimeH, categoryH, notesH, button);
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setSpacing(5);
        mainVBox.setPadding(new Insets(10, 10, 10, 10));
        mainVBox.setMaxWidth(225);
        this.getChildren().add(mainVBox);
    }

    public TextField getTitleText() {
        return titleText;
    }

    public TextField getDateText() {
        return dateText;
    }

    @Override
    public void update() {

    }

    @Override
    public void setModel(MainModel model) {

    }

    @Override
    public void associateHandler(Controller controller) {
        titleText.setOnAction(((NewActivityViewController) controller)::handleTitleText);
        dateText.setOnAction(((NewActivityViewController) controller)::handleDateText);
        button.setOnAction(((NewActivityViewController) controller)::handleAddButton);
    }


}
