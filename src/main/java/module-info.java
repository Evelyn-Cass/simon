module org.example.simon {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.simon to javafx.fxml;
    exports org.example.simon;
}