package app.morax.Controller;

import app.morax.Model.Base.Login;
import app.morax.View.LoginView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class LoginControls {

    private LoginView loginView;
    private Stage stage;
    private Stage alternateStage;

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void handleLogin(ActionEvent e) {
        String username = this.loginView.getUsername();
        String password = this.loginView.getPassword();

        Login.initialize(username, password);

        stage.close();
        alternateStage.show();
    }

    public void setAlternateStage(Stage stage) {
        this.alternateStage = stage;
    }
}
