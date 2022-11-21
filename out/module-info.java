module app.morax {

        requires javafx.controls;
        requires javafx.fxml;

        opens app.morax to javafx.graphics;
        exports app.morax;
}