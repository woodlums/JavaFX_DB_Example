package com.example.fxdb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;

import java.io.IOException;

import static com.example.fxdb.App.*;

public class PrimaryController {

    public Button primaryButton;
    public ProgressBar prog1;

    public CheckBox chk1;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public void displayAlert(ActionEvent actionEvent) {

        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.ERROR);
        a.setContentText("Don't press this button!");
        a.show();

        prog1.setProgress(.5);
    }

    public void handleCheckbox(ActionEvent actionEvent) {

        if(chk1.isSelected())
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "CHECKED");
            a.show();
        }
        else
        {
            Alert a = new Alert(Alert.AlertType.WARNING, "NOT Checked");
            a.show();
        }



    }
}
