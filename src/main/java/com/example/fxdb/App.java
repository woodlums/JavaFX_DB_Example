package com.example.fxdb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    static void setRoot(String fxml) throws IOException
    {
        scene.setRoot(loadFXML(fxml));
    }

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("primary"), 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException
    {
        FXMLLoader fxl = new FXMLLoader((App.class.getResource(fxml + ".fxml")));
        return fxl.load();
    }

    public static void main(String[] args) { launch(); }

}
