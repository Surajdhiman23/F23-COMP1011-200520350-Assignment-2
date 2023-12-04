module com.example.advancejavaassignment2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.json;

    opens com.example.advancejavaassignment2 to javafx.fxml;
    exports com.example.advancejavaassignment2;
}