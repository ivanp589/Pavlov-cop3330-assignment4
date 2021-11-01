package ucf.assignments;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
/**
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Ivan Pavlov
 */

public class ListFileActions extends ListfxmlFileController{

        // all methods have something to do
        // with the file aspect of the project



public ListFileActions() {}

    //start a new scanner
    //scan from the chosen file
    //while(line isnt null)
        //read each line
        //split each read line by the character we used to split items
            //in this case ","
        //call addItem with string parameters in ListfxmlFileController
    //end while
    public void importFromFile(File file) {
        Scanner in = null;
        try {
            in = new Scanner(file);
            while (in.hasNextLine()){
                String line = in.nextLine();
                String[] split = line.split(",");

                addItem(split[0],split[1],split[2]);
            }
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void openList(){//might have to change
        //open file picker
        //choose list you would like to open
        //import the list from the file you would like to open
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select a file");
        File file = chooser.showOpenDialog(stage);
        if(file != null){
            importFromFile(file);
        }
    }

    @FXML
    public void SaveCurrentList(){
        //get the list that is currently shown in a tab
        //open a file
        //write the contents of the list to the file
            //separate individual data values of the list with ","
            //seperate each item of the list with a new line
        //close the file
    }

    @FXML
    void SaveAllOpenLists(){
        //get the number of open lists
        //for(i=0; i<# of open lists; i++)
            //open tab i
            //call SaveCurrentList
        //end for loop
    }
}