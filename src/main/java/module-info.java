module com.tictactoefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tictactoefx to javafx.fxml;
    exports com.tictactoefx;
}