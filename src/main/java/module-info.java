module app.morax {
    requires javafx.controls;
    requires javafx.fxml;

    exports app.morax;
    exports app.morax.View;
    opens app.morax.View to javafx.fxml;
}