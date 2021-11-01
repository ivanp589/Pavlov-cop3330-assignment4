package ucf.assignments;

import java.time.LocalDate;
/**
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Ivan Pavlov
 */

public class Item extends AddItem {
    
    public String Desc;
    public LocalDate Date;
    public boolean Complete;

    //return the description string of the item
    public String getDesc(){
        return this.Desc;
    }

    //return the Date value of the item
    public LocalDate getDate(){
        return this.Date;
    }

    //return the completion status of the item
    public boolean getComplete(){
        return this.Complete;
    }

    //store the description string within the item
    public void setDescription(String description) {
        this.Desc = description;
    }

    //store the date within the item
    public void setDueDate(LocalDate dueDate) {
        this.Date = dueDate;
    }

    //store the completion status within the  item
    public void setIsComplete(Boolean isComplete) {
        this.Complete = isComplete;
    }

    public Item(){}

    //sets an item at once
    //pass the necessary values and store them within a new item
    public Item(String de,LocalDate da, Boolean c){
            //creates an Item using parameters sent.
        this.Desc=de;
        this.Date=da;
        this.Complete=c;
    }
}
