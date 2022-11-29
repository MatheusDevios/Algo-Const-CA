/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheusdiniz
 * @author carloswilker
 */
public class Reading {
    
    public List<ArrayList<String>> readFile(String fileName){
        List<ArrayList<String>> myList = new ArrayList<>(); 
        
        try {
            //create a buffered Reader and Writer
            BufferedReader myFile = new BufferedReader(new FileReader(fileName));

            //create a variable to read the next line in the Data file...
            String text = myFile.readLine();
            //and starts at the second line of the file because the first has no significant data
            text = myFile.readLine();
            // while loop to run until "text" can read nothing more in the Data file
            while(text != null){
                ArrayList<String> mySubList = new ArrayList<>(); 
                String[] result = text.split(",");
                
                //loop to populate the list of each book
                for (int i = 0; i < result.length; i++) {
                    // add to the array list the line read from the file
                    mySubList.add(result[i]);
                }
                //Adds the arrayList of each book data to the main List
                myList.add(mySubList);
                // reads the next line of the Data file
                text = myFile.readLine(); 
            }
            return myList;
        // catches some error if for some reason the program can't read from or write to its respectives files    
        }catch(Exception e){
            System.out.println("Error reading from the file or Unable to write to file: " + fileName);
        }
        return null;
    }

}
