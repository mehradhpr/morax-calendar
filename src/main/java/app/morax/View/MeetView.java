package app.morax.View;

import app.morax.Controller.Controller;
import app.morax.Controller.MeetController;
import app.morax.Interface.ModelListener;
import app.morax.Model.Base.MainModel;
import app.morax.Model.Base.Person;
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

public class MeetView extends StackPane implements ModelListener {

    private MainModel model;

    private TextField titleText;

    private TextField dateText;

    private Button addPersonB;

    private Button removePersonB;

    private Button cancelB;

    ObservableList<Person> PersonsObs = FXCollections.observableArrayList();

    ListView<Person> personsList;


    public MeetView() {
        Label title1 = new Label("All people to meet");

        personsList = new ListView<>();

        VBox leftVBox = new VBox(title1, personsList);
        leftVBox.setAlignment(Pos.CENTER);
        leftVBox.setSpacing(5);


        addPersonB = new Button("Add Person");
        removePersonB = new Button("Remove Person");
        cancelB = new Button("Cancel");
        HBox buttonsHBox = new HBox(addPersonB, removePersonB, cancelB);
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
    public void setModel(MainModel model) {
        this.model = model;
    }

    public Person getSelection(){
        return this.personsList.getSelectionModel().getSelectedItem();
    }

    public void associateHandler(MeetController controller) {
        addPersonB.setOnAction(controller::handleAddPerson);

    }

}
