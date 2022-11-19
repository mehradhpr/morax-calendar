package app.morax.View;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ErrorMessage {
    public ErrorMessage(String message){
        //the error message
        BorderPane errorMessage = new BorderPane();
        Label text = new Label("ERROR\n" + message);
        text.setFont(new Font(10));
        text.setTextAlignment(TextAlignment.CENTER);

        errorMessage.setCenter(text);

        // Starting new window
        Stage newActivityStage = new Stage();
        newActivityStage.setScene(new Scene(errorMessage, 300, 100));
        newActivityStage.getScene().getStylesheets().add("secondarySkin.css");
        newActivityStage.show();
    }
}
