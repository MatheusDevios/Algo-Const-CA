/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.ca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Carlos Wilker
 */
public class Borrows {
    
    int studentID;
    private String bookTitle;
    private String date; //Register the date when the book was borrowed

    public Borrows(int studentID, String bookTitle, String date) {
        this.studentID = studentID;
        this.bookTitle = bookTitle;
        this.date = date;

    }
    
    public Borrows(){
        
    }
    
    @Override
    public String toString(){
        return "ReaderID: "+studentID+"\n"+"Book: "+bookTitle+"\n"+"Date of return: "+date+"\n";
    }
    
    
    
    public  void borrowBook(String[] borrows) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("borrows.txt", true));
            bw.write(borrows[0] +","+borrows[1]+","+borrows[2]+"\n");
            bw.close();
        }catch(IOException e){
            System.out.println("Error!");
        }
        System.out.println("Book borrowed!");
    }
    
    public void listBooksBorrowed(int id) throws FileNotFoundException {

        ArrayList<Borrows> bw = new ArrayList<Borrows>();
        ArrayList<Borrows> array = new ArrayList<Borrows>();
        FileInputStream borrowsFile = new FileInputStream("borrows.txt");
        String line = "";

        try (BufferedReader breader = new BufferedReader(new InputStreamReader(borrowsFile))) {
            line = breader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                bw.add(new Borrows(Integer.parseInt(parts[0]), parts[1], parts[2]));
                line = breader.readLine();
            }
            
            for(int i = 0; i < bw.size(); i++){
                if( id == bw.get(i).studentID){
                    array.add(bw.get(i));
                }
            }
            
            System.out.println(bw);

        } catch (IOException e) {

        }
        System.out.println(array);

    }
    
    
    
}
