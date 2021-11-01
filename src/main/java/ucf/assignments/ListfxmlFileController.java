package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ResourceBundle;
/**
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Ivan Pavlov
 */

public class ListfxmlFileController implements Initializable {

//    public static ObservableList<Item> lister;//lister is the global list name,
    // each list gets its own individual list name which lister than stores

    Stage stage;
    public static AddList bist;

    @FXML public TableView<Item> tableView= new TableView<>();

    @FXML public TableColumn<Item,Boolean> CompColumn;

    @FXML public TableColumn<Item, LocalDate> DateColumn;

    @FXML public TableColumn<Item,String> DescColumn;

    @FXML static public  TabPane Tabpane = new TabPane();
    @FXML public CheckBox Complete;
    @FXML public CheckBox Incomplete;


    //find the number of initially open tabs
    //for(i=0; i < tabs open;i++)
        //store the  name of each tab
        //create an emptylist for each tab
        //add an element to the hashmap for each tab
    //end for
    public void makeMapOfLists(){//creates a todolist list
        int size = Tabpane.getTabs().size();

        for(int i=0;i<size;i++){
            String listName = Tabpane.getTabs().get(i).getText();
            ObservableList<Item> list= FXCollections.observableArrayList();

            new AddList(listName,list);
        }
    }

    //determine the tab that is currently being viewed
    //return the observable list located in the hashMap
    public ObservableList<Item> getCurrentList(){
        Tab currentTab = determineTab();
        String Tabname = currentTab.getText();

        return bist.getMap().get(Tabname);
    }



    //parse the sent string
    //create a new item with the parsed values
    //add the item to the current list
    public void addItem(String s, String s1, String s2) throws ParseException {
        LocalDate day = null;
        day = LocalDate.parse(s1);
        Boolean complete = Boolean.parseBoolean(s2);
        Item addItem = new Item(s,day,complete);
        getCurrentList().add(addItem);
    }

    @FXML
    //load fxml file
        //open a new scene from the file
        //set title to the new window
        //how the scene
            //set up a throw if something goes wrong
    //end
    public int actionToDo(ActionEvent event) {       //opens a new scene when the add button is pressed
        //ADD
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ListApp.class.getResource("AddingScene.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage= new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Add Item");
            stage.initModality(Modality.WINDOW_MODAL);

            stage.initOwner(((Node)event.getSource()).getScene().getWindow());
            stage.show();

            return 0;
        } catch (IOException e) {e.printStackTrace();return -1;}
    }

    //initialize the TabPane
    //make a hashMap of all open Lists
    public void ListfxmlFileConteroller() {
        bist = new AddList();
        Tabpane = new TabPane();
                makeMapOfLists();
    }


    //get the item that is passed to this function and add it to the list
    //determine list that is open
        //add the item to the list that is open.
    //end
        @FXML
    public void receiveData(Item u) {
            getCurrentList().add(u);  //adds the data to the static list
    }




    //initialize the table
        //populate the list with some data for testing purposes
        //set the table to be editable
        //for each column set the column to look for the proper data
            //i.e. set DescColumn to look for Desc data
        //for each column set the column to be editable on commit to update the item based on the users edit.
    //end
    @Override
    public void initialize(URL url, ResourceBundle rb){
        ListfxmlFileConteroller();
//        out.println(determineTab());
        try {
            initializer();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tableView.setEditable(true);

        DescColumn.setCellValueFactory(new PropertyValueFactory<>("Desc"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        CompColumn.setCellValueFactory(new PropertyValueFactory<>("Complete"));

//        DescColumn.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setDescription(event.getNewValue()));
//        DateColumn.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setDueDate(event.getNewValue()));
//        CompColumn.setOnEditCommit(event -> (event.getTableView().getItems().get(event.getTablePosition().getRow())).setIsComplete(event.getNewValue()));

    }


    //get number of tabs
    //for(i=0; i< number of tabs; i++)
        //if(tab is focused)
            //set Tab variable to this tab
        //end if
    //end for
    //return Tab variable
    public Tab determineTab(){//potentially change is selected to something else...
        int size = Tabpane.getTabs().size();
        int i;
        Tab currentTab = new Tab();
        for(i=0;i<size;i++){
            if(Tabpane.getTabs().get(i).isSelected()){
                currentTab = Tabpane.getTabs().get(i);
            }

        }
        return currentTab;
    }

    //determine list that is open
    //set the list to the table
    //end
    private void initializer() throws ParseException {//excessive to call bc only one line
        tableView.setItems(getCurrentList());
    }





    //button to manually refresh the table
    //set the list to the table
    //set checkboxes off.       //to not confuse the user
    //end
    @FXML void Refresher(){
        tableView.setItems(getCurrentList());
        Incomplete.selectedProperty().set(false);
        Complete.selectedProperty().set(false);
//        out.println("Refresher Button");//test line to see if the function was called

//        out.println(Tabpane.getTabs().get(0).isSelected());//true is tab 0 is the current one
    }

    //Note: the edit functions work if a button is used to call them, but that seems inefficient
    //also not currently implemented that way

    //function to edit the description of an item
    //retrieve an item from the table
    //edit the value of the item retrieved
    //refresh the table
    public void editDescription(TableColumn.CellEditEvent<Item, String> todoItemStringCellEditEvent) {
        Item item = tableView.getSelectionModel().getSelectedItem();
        item.setDescription(todoItemStringCellEditEvent.getNewValue());
    }

    //function to edit the due date of an item
    //retrieve an item from the table
    //edit the value of the item retrieved
    //refresh the table
    public void editDueDate(TableColumn.CellEditEvent<Item, LocalDate> todoItemDateCellEditEvent) {
        Item item = tableView.getSelectionModel().getSelectedItem();
        item.setDueDate((todoItemDateCellEditEvent.getNewValue()));
    }

    //function to edit the completion status of an item
    //retrieve an item from the table
    //edit the value of the item retrieved
    //refresh the table
    public void editIsComplete(TableColumn.CellEditEvent<Item, Boolean> todoItemBooleanCellEditEvent) {
        Item item = tableView.getSelectionModel().getSelectedItem();
        item.setIsComplete((todoItemBooleanCellEditEvent.getNewValue()));
    }


    //all code after may have to be edited to work properly

    public ObservableList<Item> getCompleted(){
        //create a newItemList and populate it only with completed items
        //for(i=0,i<sizeof( original list );i++)
            //if(originalList.get(i).getComplete() == true)
                //newItemList.add(original list element i)
            //else continue
        //return newItemList
        ObservableList<Item> completeList= FXCollections.observableArrayList();
        int size = getCurrentList().size();
        for(int i=0; i<size;i++){
            if(getCurrentList().get(i).getComplete() == true){
            completeList.add(getCurrentList().get(i));
            }
        }
        return completeList;
    }
    @FXML
    public void showCompleted(){
        //check if both checkboxes are on
            //if true set both to off
        //set the table with the completed items
        //tableView.setItems(getCompleted())
        //refresh the table
        if(Complete.isSelected() && Incomplete.isSelected()){
            Complete.selectedProperty().set(false);
            Incomplete.selectedProperty().set(false);
        }
        else if(Complete.isSelected()){
            tableView.setItems(getCompleted());
        }

    }
    public ObservableList<Item> getIncomplete(){
        //create a newItemList and populate it with only incomplete items
        //for(i=0,i<sizeof(originalList);i++)
            //if(originalList.get(i).getComplete() == false)
                //newItem.add(original list element i)
            //else continue
        //return newItemList
        ObservableList<Item> incompleteList= FXCollections.observableArrayList();
        int size = getCurrentList().size();
        for(int i=0; i<size;i++){
            if(getCurrentList().get(i).getComplete() == false){
                incompleteList.add(getCurrentList().get(i));
            }
        }
        return incompleteList;
    }

    public void showIncomplete(){   //show incomplete checkbox triggers this
        //set the other checkbox to off or false
        //set the table with the incomplete items
        //tableView.setItems(getIncomplete())
        //refresh the table
        if(Complete.isSelected() && Incomplete.isSelected()){
            Complete.selectedProperty().set(false);
            Incomplete.selectedProperty().set(false);
        }
        else if(Incomplete.isSelected()) {
            tableView.setItems(getIncomplete());
        }
    }

    @FXML
    public void CloseList() {       //close list button triggers this event
        //identify the tab that is currently open
        //close the tab that is currently open
        //note: could add saving functionality but not necessary
    }

    @FXML
    public void CreateNewList() throws IOException {
       // create a Tab variable
            //initialize the tab variable...
            //set the name of the tab
        //create a new TableView
            //initialize the tableView to be consistent
            //set each column of the table
        //set the newTable to the content of the tab
        //add the newTab to the TabPane
        int X= Tabpane.getTabs().size()+1;
        Tab newtab = new Tab();
        newtab.setText("Tab "+X);//let the title of the tab be the name of the list we will be updating
        TableView newTable = new TableView<Item>();
        TableColumn comp = new TableColumn<Item,Boolean>("Completed:");
        comp.setPrefWidth(75.00);
        TableColumn date = new TableColumn<Item,LocalDate>("Due Date:");
        date.setPrefWidth(75.00);
        TableColumn desc = new TableColumn<Item,String>("Description:");
        desc.setPrefWidth(454.4000183105469);
        newTable.getColumns().add(comp);
        newTable.getColumns().add(date);
        newTable.getColumns().add(desc);
        newtab.setContent(newTable);
        Tabpane.getTabs().add(newtab);

    }

    @FXML
    void RenameList(){
        //open a new window which asks for a new list name
        //store this list name as the name of the list in ListData
        //setListName();
        //CALL saveCurrentList()
    }

    @FXML
    void clearList(){
        //get the list of the list that is currently being viewed
        //clear this list, leave all others untouched
        getCurrentList().clear();
    }
    @FXML
    void removeItemFromList(){
            //have the user select an item from the table
            //store this item for removal
            //remove this item
            //leave all other items untouched
        Item item = tableView.getSelectionModel().getSelectedItem();
        getCurrentList().remove(item);

    }

    //following code is simplified to make this file smaller

    @FXML
    public void openList(){//might have to change
        //call openList in FileACtions
        ListFileActions actions = new ListFileActions();
        actions.openList();
        }




    @FXML
    void SaveCurrentList(){
        //call SaveCurrentList in FileActions
        ListFileActions actions = new ListFileActions();
        actions.SaveCurrentList();
    }

    @FXML
    void SaveAllOpenLists(){
        //call SaveAllOpenLists in FileActions
        ListFileActions actions = new ListFileActions();
        actions.SaveAllOpenLists();
    }
}
