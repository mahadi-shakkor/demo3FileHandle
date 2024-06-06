module com.oop.mahadi.demo3filehandle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.mahadi.demo3filehandle to javafx.fxml;
    exports com.oop.mahadi.demo3filehandle;
}