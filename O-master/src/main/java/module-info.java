module org.example{

    requires org.hibernate.orm.core;
    requires java.sql;

    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires jakarta.persistence;

    opens org.example to javafx.fxml;
    exports org.example;


}
