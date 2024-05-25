module com.temperature.temperaturetool {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens com.temperature.temperaturetool to javafx.fxml;
    exports com.temperature.temperaturetool;
}