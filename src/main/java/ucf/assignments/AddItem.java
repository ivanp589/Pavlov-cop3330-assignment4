package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Ivan Pavlov
 */

public class AddItem {
    @FXML private TextField DescriptionString;
    @FXML private DatePicker DueDateValue;

    //send data to another controller
    //gather the data from the scene we are currently in
    //create an item
    //get the stage of this scene
        //close the scene
    //call receiveData to update the list from this method
    @FXML
    public void sendData(ActionEvent event) {
        Item u = new Item(DescriptionString.getText(),DueDateValue.getValue(),false);
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

        ListfxmlFileController controller = new ListfxmlFileController();
        controller.receiveData(u);
    }
}
