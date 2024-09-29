module com.example.heiwukongtool {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.labixiaoxin.heiwukongtool to javafx.fxml;
    exports com.labixiaoxin.heiwukongtool;

    opens com.labixiaoxin.heiwukongtool.entity to javafx.base;
    exports com.labixiaoxin.heiwukongtool.entity;
}