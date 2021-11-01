module ucf.assignments {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires junit;
    requires org.junit.jupiter.api;


    opens ucf.assignments to javafx.fxml;
    exports ucf.assignments;
}