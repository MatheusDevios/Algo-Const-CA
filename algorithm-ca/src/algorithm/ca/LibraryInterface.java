/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.ca;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Proposal of interface in order to call all the functionalities of the menu
 * @author Carlos Wilker
 */
public interface LibraryInterface {
    
    // Load all books from the text file
    public ArrayList<Books> loadBookDataFile() throws FileNotFoundException;
    
    // Load all students from the text file
    //public ArrayList<Students> loadStudents() throws FileNotFoundException;
    
    // 1 - Get a book by title
    //public void getBookTitle(ArrayList<Books> book, String title);
    
    // 2 - Get a book by Author
    //public void getBookAuthor(ArrayList<Books> book, String author);
    
    // 3 - sort books by title
    // public void sortBooksByTitle(ArrayList<Books> books);
     
    // 4 - sort books by Author 
    //public void sortBooksByAuthor(ArrayList<Books> books);
    
    // 5- Get a student by name
    //public void getFirstName(ArrayList<Students> student, String name);
    
    // 6 - Get a student by ID
   // public void getStudentId(ArrayList<Students> student, int id);
    
    // 7 - sort students by name
    //public void sortStudentsByName(ArrayList<Students> students);
    
    // 8 - sort readers by id
    //public void sortStudentsById(ArrayList<Students> students);
    
    // 9 - Register that a reader has borrowed a book
    public  void borrowBook(String[] borrows) throws IOException;
    
    // 10 - Register that a reader has returned a book
    // public  void returnBook(String[] returns) throws IOException;
     
     // 11 - For a specific reader, list  the books that they have borrowed
    public void listBooksBorrowed(int id) throws FileNotFoundException;   
     
}
