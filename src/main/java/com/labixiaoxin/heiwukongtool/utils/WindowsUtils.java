package com.labixiaoxin.heiwukongtool.utils;

import javafx.scene.control.Alert;

/**
 * @author admin
 */
public class WindowsUtils {
    public static void alertError(String title,String headerText,String contentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public static void alertInformation(String title,String headerText,String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
