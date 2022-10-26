module com.cmpt370.cmpt370 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cmpt370.cmpt370 to javafx.fxml;
    exports com.cmpt370.cmpt370;
}