module app.morax {

        requires javafx.graphics;
        requires javafx.controls;
        requires javafx.fxml;
    requires jbcrypt;
    requires java.sql;

    opens app.morax to javafx.graphics;
        exports app.morax;
}