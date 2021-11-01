package ucf.assignments;

import javafx.collections.ObservableList;

import java.util.HashMap;
/**
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Ivan Pavlov
 */

public class AddList {

    public static HashMap<String,ObservableList<Item>> mapOflisters = new HashMap<String,ObservableList<Item>>();

    //add an element to the hashMap
    public AddList(String listnamesent, ObservableList<Item> listsent){
        mapOflisters.put(listnamesent,listsent);
    }

    //return the HashMap
    public static HashMap<String,ObservableList<Item>> getMap(){
        return mapOflisters;
    }

    public AddList(){}


}
