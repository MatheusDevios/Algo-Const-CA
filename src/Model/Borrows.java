/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * @author carloswilker
 * @author matheusdiniz
 */
public class Borrows {
    
    String studentID;
    private String bookTitle;
    private String date; //Register the date when the book was borrowed

    public Borrows(String studentID, String bookTitle, String date) {
        this.studentID = studentID;
        this.bookTitle = bookTitle;
        this.date = date;

    }

    public String getStudentID() {
        return studentID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getDate() {
        return date;
    }
    
    @Override
    public String toString(){
       return "\nStudent ID: "+studentID+"\n"+"Book: "+bookTitle+"\n"+"Date of return: "+date;
    }
    
}
