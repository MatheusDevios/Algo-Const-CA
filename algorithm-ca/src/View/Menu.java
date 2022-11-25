/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author matheusdiniz
 */
public class Menu {
    
     /**
     * Display the menu to the user.
     */
    public void getMenu(){
        System.out.println("\n**** LIBRARY MENU ****.\n"
                + "Option 1 = Search for a specific book by title or author.\n"
                + "Option 2 = List books by title or author.\n"
                + "Option 3 = Search for a specific student by name or ID.\n"
                + "Option 4 = List all student by name or ID.\n"
                + "Option 5 = Register borrowed book.\n"  
                + "Option 6 = Register return book.\n"  
                + "Option 7 = List all books borrowed from a specific student by ID.\n"  
                + "Option 8 = Exit.\n");
    }
    public void getMenuBooksSearch() {
        System.out.println("Option 1 = Search for a book by Title.\n"
                + "Option 2 = Search for a book by Author.\n");
    }
    public void getMenuStudentSearch() {
        System.out.println("Option 1 = Search for a student by name.\n"
                + "Option 2 = Search for a student by ID.\n");
    }
    public void getMenuBooksList() {
        System.out.println("Option 1 = List for a student by title.\n"
                + "Option 2 = List for a student by Author.\n");
    }
    public void getMenuStudentList() {
        System.out.println("Option 1 = List for a student by Name.\n"
                + "Option 2 = List for a student by ID.\n");
    }
    
}
