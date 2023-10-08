module com.hospitalmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;
    requires java.logging;
    requires java.sql;

    opens com.hospitalmanagementsystem to javafx.fxml;
    exports com.hospitalmanagementsystem;
}
