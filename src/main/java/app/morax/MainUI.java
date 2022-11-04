package app.morax;

import app.morax.Controller.MainController;
import app.morax.Model.Base.MainModel;
import app.morax.View.MainView;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class MainUI extends StackPane {

    MainUI() {
        MainView primaryView = new MainView();
        MainController primaryController = new MainController();
        MainModel primaryModel = new MainModel();

        primaryView.setModel(primaryModel);
        primaryView.associateHandler(primaryController);
        primaryController.setModel(primaryModel);

        this.getChildren().add(primaryView);
        this.setAlignment(Pos.CENTER);
    }



}
