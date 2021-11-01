package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Ivan Pavlov
 */

public class ListApp extends Application {




    //load the fxml file
    // create a new scene based on it
    //throw an exception if anything goes wrong
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ListApp.class.getResource("ListfxmlFile.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 605, 400);
        stage.setTitle("listName");
        stage.setScene(scene);
        stage.show();
    }
    //starts the program
    public void main() {
        launch();
    }
}