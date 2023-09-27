module com.hospitalmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.hospitalmanagementsystem to javafx.fxml;
    exports com.hospitalmanagementsystem;
}
