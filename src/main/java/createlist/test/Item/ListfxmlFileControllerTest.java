package createlist.test.Item;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


import static org.junit.Assert.assertEquals;

/**
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Ivan Pavlov
 */

public class ListfxmlFileControllerTest {
    @Test
    @DisplayName("#6 add new list")
    void newlist(){
        //call CreateNewList()
        //store the size of the list
            //a new list should have a size of zero
        //int actual = list.size()
        //int expected = 0
        //assertEquals(expected,actual);
    }

    @Test
    @DisplayName("#7 remove existing list")//maybe count how many lists are opened at once,
    //clear the list to be removed and take that list away... list of lists?
    void Removelist(){
        //call clearList( list to be removed)
        //int actual = removedlist.size()
        //int expected = 0
        //assertEquals(expected,actual);
    }

    @Test
    @DisplayName("#8 title editing")
    void TitleTest(){
        //call setTitle(new title)
        //String actual = title
        //String expected = new title
        //assertEquals(expected,actual);
    }

    @Test
    @DisplayName("#9 ability to add new item to todo list")//
    void TcoDoList_test1() throws InstantiationException, IllegalAccessException {
        //CREATE ListfxmlFileController list = new ListfxmlFileController()
        //CREATE ToDoList add= new ToDoList()
        //CALL add method CreateItem with parameters ("desc",LocalDate.of(2021,9,28), false)
              //now that an item is created we must add it to the list
        //CALL list.actionToDO to open a new window to add an item to the list
        //ENTER values into the textbox and datepicker
        //press "add Item"
        //String test = get the description of the newest item of the list
                //newest item of the list will be in lister.size()-1 position
        //String actual = test
        //String expected = whatever you entered into the description textbox
        //assertEquals(expected,actual);
                //is fails that means the item was not added to the list
    }

    @Test
    @DisplayName("#10 remove item from list")
    void removeItemTest(){
        //call removeItemFromList(item to remove, list to remove from)
        //boolean actual = list.contains(item we wanted to remove)
        //boolean expected = false
        //assertEquals(expected,actual);
    }

    @Test
    @DisplayName("#11 edit description")
    void editDescriptionTest(){
        //call editDescription()
        //String actual = item.getDescription
                //item being the item we wanted to edit
        //String expected = new description
        //assertEquals(expected,actual);
    }
    @Test
    @DisplayName("#12")
    void editDueDateTest(){
        //call editDueDate()
        //LocalDate actual = item.getDate
                //item being the item we wanted to edit
        //LocalDate expected = new Date
        //assertEquals(expected,actual);
    }
    @Test
    @DisplayName("#13")
    void editCompleteTest(){
        //call editIsComplete()
        //boolean actual = item.getComplete
                //item being the item we wanted to edit
        //boolean expected = new complete
        //assertEquals(expected,actual);
    }
    @Test
    @DisplayName("#14")
    void ShowAllItemsTest(){
        //set incomplete and complete checkbox off
        //get the size of the list
        //int actual = size of list
        //int expected = #of elements we have within the list
        //assertEquals(expected,actual);
        //note: if incomplete checkbox and complete
        // checkbox are checked we might not get the correct list
    }
    @Test
    @DisplayName("#15")
    void showIncompleteTest(){
        //set incomplete checkbox on and complete checkbox off
        //get size of the list generated
        //int actual = size of the list
        //int expected = number of incomplete elements
        //assertEquals(expected,actual);
    }
    @Test
    @DisplayName("#16")
    void showCompletedTest(){
        //set complete checkbox on and incomplete checkbox off
        //get size of the list generated
        //int actual = size of the list
        //int expected = number of complete elements
        //assertEquals(expected,actual);
    } @Test
    @DisplayName("#17")
    void SaveSingleTest(){
        //call saveCurrentList()
        //get the size of the current list
        //int expected = size of current list
        //call openList() and open the list that was just saved
        //get the size of this list
        //int actual = size of this list
        //assertEquals(expected,actual);
    } @Test
    @DisplayName("#18")
    void SaveAllTest(){
        //call save all open lists
        //call openlist, open the list which we just saved
        //int actual = size of the opened list
        //int expected = number of elements within all lists
        //assertEquals(expected,actual);
    } @Test
    @DisplayName("#19")
    void openListTest(){
        //call open list
        //boolean actual = list != null
        //boolean expected = true
        //assertEquals(expected,actual);
    }

    @Test
    @DisplayName("#20")
    void LoadMultiple(){
        //call openList()
        //call openList()
        //if( both lists are not null)
            //set boolean actual to true
        //boolean expected = true
        //assertEquals(expected,actual)
    }
}
