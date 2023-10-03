module com.hospitalmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.hospitalmanagementsystem to javafx.fxml;
    exports com.hospitalmanagementsystem;
}
