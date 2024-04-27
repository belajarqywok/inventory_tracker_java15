module com.rionggo.inventorytracker.controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.rionggo.inventorytracker.controller to javafx.fxml;
    opens com.rionggo.inventorytracker.models to javafx.base;

    exports com.rionggo.inventorytracker;
}
