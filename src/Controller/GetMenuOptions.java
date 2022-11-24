/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Books;
import Model.Borrows;
import Model.Queue;
import Model.Returns;
import Model.Students;
import View.GetUserInput;
import View.Menu;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author matheusdiniz
 */
public class GetMenuOptions {
    
    public void getMenuOptions() throws IOException{ 
        
        Menu menu = new Menu();
        Data data = new Data();
        GetUserInput input = new GetUserInput();
        Searching search = new Searching();
        Sorting sorting = new Sorting();
        List<Books> books = data.loadBooks();
        List<Students> student = data.loadStudents();
        List<Queue> queue = data.loadQueue();
        List<Returns> returnList = data.loadReturns();
        List<Borrows> borrowList = data.loadBorrows();
        int optionChosen;
        Scanner scanner = new Scanner(System.in);
        //do-while to run the main code, menu and structure
        do {
            //calls the menu
            menu.getMenu();
            //asks the user for an input between 1 and 8
            optionChosen = input.getUserMenu("Pick an option.", 1, 8);
             //in each case the user chooses an option, it does the respective one
            switch(optionChosen){
                case 1:
                    menu.getMenuBooksSearch();
                    int bookCategory = input.getUserIntValue("Select the number corresponding to the search you want to see.", 1, 2);
                    switch(bookCategory) {
                        case 1:
                            //search book by Title
                            List<Books> sortedBooks2 = sorting.mergeSortBook(books, 2);
                            System.out.println("Please type the book title: ");
                            String bookTitle = scanner.nextLine();
                            Books resultBook2 = search.binarySearchBooks(sortedBooks2, bookTitle.toLowerCase(), 2);
                            if (resultBook2 != null) {
                                System.out.println(resultBook2.toString());
                            } else {
                                System.out.println("Sorry, we do not have this Book.");
                            }
                            break;
                        case 2:
                            //search book by Author
                            List<Books> sortedBooks = sorting.mergeSortBook(books, 1);
                            System.out.println("Author Full Name: ");
                            String authorFullName = scanner.nextLine();
                            Books resultBook = search.binarySearchBooks(sortedBooks, authorFullName.toLowerCase(), 1);
                            if (resultBook != null) {
                                System.out.println(resultBook.toString());
                            } else {
                                System.out.println("Sorry, we do not have a Book with this author name.");
                            }
                            break;
                    }
                    break;
                case 2:
                    menu.getMenuBooksList();
                    int listBookByCategory = input.getUserIntValue("Select the number corresponding to the list you want to see.", 1, 2);
                    switch(listBookByCategory) {
                        case 1:
                            //list book by title
                            List<Books> sortedBooksT = sorting.mergeSortBook(books, 2);
                            for (Books book : sortedBooksT){
                                System.out.println(book.toString());
                            }
                            break;
                        case 2:
                            //list book by Author
                            List<Books> sortedBooksA = sorting.mergeSortBook(books, 1);
                            for (Books book : sortedBooksA){
                                System.out.println(book.toString());
                            }
                            break;
                    }
                    break;
                case 3:
                    menu.getMenuStudentSearch();
                    int studentCategory = input.getUserIntValue("Select the number corresponding to the search you want to see.", 1, 2);
                    switch(studentCategory) {
                        case 1:
                            //search book by name
                            List<Students> sortedStudentsN = sorting.mergeSortStudent(student, 1);
                            System.out.println("Student Full Name: ");
                            String studentFullName = scanner.nextLine();
                            Students resultStudentN = search.binarySearchStudent(sortedStudentsN, studentFullName.toLowerCase(), 1);
                            if (resultStudentN != null) {
                                System.out.println(resultStudentN.toString());
                            } else {
                                System.out.println("Sorry, we do not have a Student with this name, please make sure you type the student full name.");
                            }
                            break;
                        case 2:
                            //search book by ID
                            List<Students> sortedStudentsID = sorting.mergeSortStudent(student, 2);
                            System.out.println("Please type the Student ID: ");
                            String studentID = scanner.nextLine();
                            Students resultStudentID = search.binarySearchStudent(sortedStudentsID, studentID, 2);
                            if (resultStudentID != null) {
                                System.out.println(resultStudentID.toString());
                            } else {
                                System.out.println("Sorry, we do not have this Book.");
                            }
                            break;
                    }
                    break;
                case 4:
                    menu.getMenuStudentList();
                    int listStudentByCategory = input.getUserIntValue("Select the number corresponding to the list you want to see.", 1, 2);
                    switch(listStudentByCategory) {
                        case 1:
                            //list student by Name
                            List<Students> sorteStudentN = sorting.mergeSortStudent(student, 1);
                            for (Students person : sorteStudentN){
                                System.out.println(person.toString());
                            }
                            break;
                        case 2:
                            //list student by ID
                            List<Students> sorteStudentID = sorting.mergeSortStudent(student, 2);
                            for (Students person : sorteStudentID){
                                System.out.println(person.toString());
                            }
                            break;
                    }
                    break;
                case 5:
                    // Register borrowed book
                    System.out.println("StudentID: ");
                    String studentIdBorrow = scanner.nextLine();
                    System.out.println("Book name: ");
                    String bookNameBorrowed = scanner.nextLine();
                    DateTimeFormatter borrowedDTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    LocalDateTime borrowedLDT = LocalDateTime.now();
                    String dateBorrowed = borrowedDTF.format(borrowedLDT);
                    String[] bookData = {studentIdBorrow,bookNameBorrowed,dateBorrowed};
                   
                    //queue
                    String bookSearched = search.queueSearchBorrow(borrowList, bookNameBorrowed);
                    if (bookSearched.toLowerCase().contains(bookNameBorrowed.toLowerCase())){
                        System.out.println("\nThis book is borrowed, let me add you on the waiting list.");
                        System.out.println("Option 1 = Yes.\n"
                                           + "Option 2 = No.\n");
                        int queueOption = input.getUserIntValue("Select the number corresponding to your intention.", 1, 2);

                        switch(queueOption){
                            case 1:
                                data.bookQueue(bookData);
                                queue = data.loadQueue();
                                break;
                            case 2: 
                                System.out.println("\nYou have decided not to save your request to the waiting list.");
                                break;
                        }
                        
                    } else{
                        data.borrowBook(bookData);
                        borrowList = data.loadBorrows();
                    }
                    break;   
                case 6:
                    // Register return book ****
                    System.out.println("StudentID: ");
                    String studentIdReturned = scanner.nextLine();
                    System.out.println("Book name: ");
                    String bookNameReturned = scanner.nextLine();
                    DateTimeFormatter returnedDTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    LocalDateTime returnedLDT = LocalDateTime.now();
                    String dateReturned = returnedDTF.format(returnedLDT);
                    String [] book = {studentIdReturned,bookNameReturned,dateReturned};
                    data.returnBook(book);
                    returnList = data.loadReturns(); //****
                    // do the queue ****
                    String bookSearchedReturned = search.queueSearchReturn(queue, bookNameReturned);
                    String resultId[]= bookSearchedReturned.split(",");
                    //splt in order to get the studentID
                    if (bookSearchedReturned.toLowerCase().contains(bookNameReturned.toLowerCase())){
                        List<Students> sortedStudentsID = sorting.mergeSortStudent(student, 2);
                        Students studentResult = search.binarySearchStudent(sortedStudentsID, resultId[0], 2);
                        if (studentResult!=null) {
                            System.out.println(studentResult.toString());
                        }else{
                            System.out.println("Sorry, we could not find this student on our data, please check if the student ID is correct.");
                        }
                    } else{
                        System.out.println("There is no waiting list for this book.");
                    }
                    break;   
                case 7:
                    // List all books borrowed book from student ID
                    System.out.println("StudentID: ");
                    String studentID = scanner.nextLine();
                    search.queueSearchStudentBorrowList(borrowList, studentID);
                    break;   
                case 8:
                    //Close the menu and shows a message to the user saying that they chose to finish it.
                    System.out.println("\nYou have decided to Exit/Quit the application.");
                    break;
            default:
                System.out.println("Unknown Error -- the system didn't find what you typed!");
                break;
            }
          //condition to run until the option chosen from the user is 6 and if it is 6, finish the application.   
        } while (optionChosen != 8);
    }
    
}
//687vnc203