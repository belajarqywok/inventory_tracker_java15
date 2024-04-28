module com.rionggo.inventorytracker.controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires transitive javafx.graphics;

    opens com.rionggo.inventorytracker.Entities to javafx.base;
    opens com.rionggo.inventorytracker.Handlers to javafx.fxml;

    exports com.rionggo.inventorytracker;
}
