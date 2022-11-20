package app.morax.View;

import app.morax.Controller.NewActivityController;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.Category;
import app.morax.Model.Base.HourModel;
import app.morax.Model.Base.MainModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewActivityView extends StackPane implements ModelListener {

    private TextField titleText;

    private TextField dateText;

    private TextField locationText;

    ObservableList<Category> categoriesObs = FXCollections.observableArrayList();

    ObservableList<String> AMPMCombo = FXCollections.observableArrayList("AM", "PM");

    public ComboBox<String> PmAmC = new ComboBox<>(AMPMCombo);


    public TextField timeText = new TextField();

    private Button addB;

    private Button cancelB;
    public DatePicker DT = new DatePicker();

    public CheckBox setTimeCk = new CheckBox();



    private MainModel model;

    private ComboBox<Category> categoryC;

    public NewActivityView() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);

        Label title1 = new Label("New Activity");


        Label title2 = new Label("Title: ");
        titleText = new TextField("Activity");
        HBox titleHBox = new HBox(title2, titleText);
        titleHBox.setAlignment(Pos.CENTER_LEFT);

        Label title3 = new Label("Date: ");
        DT.setMaxWidth(120);
        DT.getEditor().setText(currentTime.substring(8, 10) + "/" + currentTime.substring(5, 7) + "/" + currentTime.substring(0, 4));
        HBox dateHBox = new HBox(title3, DT);
        dateHBox.setAlignment(Pos.CENTER_LEFT);

        Label locationTitle = new Label("Location: ");
        locationText = new TextField();
        locationText.setText("Home");
        locationText.setMaxWidth(100);
        HBox locationHBox = new HBox(locationTitle, locationText);
        locationHBox.setAlignment(Pos.CENTER_LEFT);

        Label title4 = new Label("Set Time: ");

        HourModel HM = new HourModel(currentTime.substring(11, 13), null);

        timeText.setText(HM.getHour12() + ":" + currentTime.substring(14, 16));
        timeText.setMaxWidth(50);
        timeText.setDisable(true);
        PmAmC.setValue(HM.getAMPM());
        PmAmC.setMinWidth(10);
        PmAmC.setDisable(true);
        HBox setTimeH = new HBox(title4, setTimeCk, timeText, PmAmC);
        setTimeH.setSpacing(5);
        setTimeH.setAlignment(Pos.CENTER_LEFT);

        Label title5 = new Label("Category: ");
        categoryC = new ComboBox<>();
        categoryC.setItems(this.categoriesObs);
        categoryC.setMinWidth(120);
        categoryC.setValue(new Category("Work", 1, 1, 20));
        HBox categoryH = new HBox(title5, categoryC);
        categoryH.setAlignment(Pos.CENTER_LEFT);

        Label title6 = new Label("Notes: ");
        TextArea t = new TextArea();
        t.setMaxWidth(150);
        HBox notesH = new HBox(title6, t);

        addB = new Button("Add");
        cancelB = new Button("Cancel");
        HBox buttonHBox = new HBox(addB, cancelB);
        buttonHBox.setSpacing(10);
        buttonHBox.setAlignment(Pos.TOP_CENTER);

        VBox mainVBox = new VBox(title1, titleHBox, dateHBox, locationHBox, setTimeH, categoryH, notesH, buttonHBox);
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setSpacing(5);
        mainVBox.setPadding(new Insets(10, 10, 10, 10));
        mainVBox.setMaxWidth(300);
        this.getChildren().add(mainVBox);
    }

    public TextField getTitleText() {
        return titleText;
    }

    public TextField getDateText() {
        return dateText;
    }

    public ComboBox<Category> getCategoryC() {
        return categoryC;
    }

    public TextField getTimeText() {
        return timeText;
    }

    public TextField getLocationText() {
        return locationText;
    }

    @Override
    public void update() {
        categoriesObs.clear();
        categoriesObs.addAll(this.model.getCategories());
        categoryC.setItems(categoriesObs);

    }

    @Override
    public void setModel(MainModel model) {
        this.model = model;
        categoriesObs.setAll(model.getCategories());

        this.update();
    }

    public void associateHandler(NewActivityController controller) {
        titleText.setOnAction(controller::handleTitleText);
        addB.setOnAction(((NewActivityController) controller)::handleAddButton);
        cancelB.setOnAction(controller::handleCancelB);
        setTimeCk.setOnAction(((NewActivityController) controller)::handleSetTimeCheckBox);
    }

}
