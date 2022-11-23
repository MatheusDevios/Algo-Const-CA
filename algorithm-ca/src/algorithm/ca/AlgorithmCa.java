/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.ca;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class AlgorithmCa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        new AlgorithmCa();

        Scanner sc = new Scanner(System.in);

        BookFile data = new BookFile(); //
        ArrayList<Books> books = data.loadBookDataFile();
        
        Borrows newB = new Borrows();
        
        
        boolean status = false;

        do {
            System.out.println("Menu");
            System.out.println("1 - Register borrow");
            System.out.println("2 - List all books borrowed by a student");
            System.out.println("3 - Exit");

            try {
                int option = Integer.parseInt(sc.nextLine());
                switch (option) {

                    case 1:

                        System.out.println("ReaderID: ");
                        String readerId = sc.nextLine();
                        System.out.println("Book name: ");
                        String book = sc.nextLine();
                        DateTimeFormatter datetf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        LocalDateTime localdt = LocalDateTime.now();
                        String date = datetf.format(localdt);
                        String[] borrow = {readerId, book, date};
                        newB.borrowBook(borrow);
                        break;
                    case 2:
                       System.out.println("StudentID: ");
                       String studentID = sc.nextLine();
                       data.listBooksBorrowed(Integer.parseInt(studentID));
                       break;
                    case 3:
                        status = true;
                        break;
                    case 4:
                         System.out.println("StudentID: ");
                          String sID = sc.nextLine();
                        break;
                    default:
                        System.out.println("Wrong Option!");
                        break;

                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        } while (status == false);
    }

    public AlgorithmCa() {

        List<ArrayList<String>> myList = new ArrayList<>();
        List<ArrayList<String>> myList2 = new ArrayList<>();
        
        List<ArrayList<String>> myList3 = new ArrayList<>();

        myList = readingBookingFile();
        
        myList2 = readingStudentFile();
        
        myList3 = listBooksBorrowed();

        System.out.println("\nBooking archive");
        printArray(myList);
        System.out.println("\nStudent archive");
        printArray(myList2);
        System.out.println("\nBooks borrowed");
        printArray(myList3);

        //System.out.println(binarySearchAuthor(myList, "Adams MacCague"));
        System.out.println(binarySearchStudent(myList2,"Far"));

    }

    /*
    Method to read a file with the information about all the books
     */
    public List<ArrayList<String>> readingBookingFile() {

        List<ArrayList<String>> myList = new ArrayList<>();

        try {
            //create a buffered Reader and Writer
            BufferedReader myFile = new BufferedReader(new FileReader("MOCK_DATA.txt"));

            //create a variable to read the next line in the Data file...
            String text = myFile.readLine();
            //and starts at the second line of the file because the first has no significant data
            text = myFile.readLine();

            // while loop to run until "text" can read nothing more in the Data file
            while (text != null) {
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

        } catch (Exception e) {
            System.out.println("Error reading the file");

            return null;
        }
    }

    /*
    Method to read a file with the information about all the students
     */
    public List<ArrayList<String>> readingStudentFile() {

        List<ArrayList<String>> myList = new ArrayList<>();

        try {
            //create a buffered Reader and Writer
            BufferedReader myFile = new BufferedReader(new FileReader("MOCK_STUDENT.txt"));

            //create a variable to read the next line in the Data file...
            String text = myFile.readLine();
            //and starts at the second line of the file because the first has no significant data
            text = myFile.readLine();

            // while loop to run until "text" can read nothing more in the Data file
            while (text != null) {
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

        } catch (Exception e) {
            System.out.println("Error reading the file");

            return null;
        }

    }

    /*
    Print the information inside an array
     */
    public void printArray(List<ArrayList<String>> array) {

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }

    }

    public String binarySearchStudent(List<ArrayList<String>>array, String name){
        
        //Index pointers
        int start = 0;
        int middle;
        int end = array.size() - 1;
        String fullName = "";

        while (start <= end) {

            middle = (start + end) / 2;
            fullName = array.get(middle).get(1) + " " + array.get(middle).get(2);
            System.out.println("Searching in position: " + fullName);

            if (fullName.contains(name)) {

                return middle + fullName;
                
            } else if (fullName.compareTo(name) < 0) {

                start = middle + 1;

            } else {

                end = middle - 1;

            }

        }

        return "Not found this time";

    
        
        
    }
    /*
    Binary search using author first name as a valid input
     */
    public String binarySearchAuthor(List<ArrayList<String>> array, String name) {

        //Collections.sort(array);
        //System.out.println("Sorted array: " + array);
        //Index pointers
        int start = 0;
        int middle;
        int end = array.size() - 1;
        String result = "";

        while (start <= end) {

            middle = (start + end) / 2;
            result = array.get(middle).get(1) + " " + array.get(middle).get(2);

            //Print the searching through each interaction
            //System.out.println("Searching element in position: " + middle);
            if (result.contains(name)) { //compare the name to the variable

                return result + " found at index: " + middle;

            } else if (result.compareTo(name) < 0) { //if the name is smaller than the middle, go left

                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return "Element not found";

    }

    public String binarySearchTitle(List<ArrayList<String>> array, String name) {

        //Collections.sort(array);
        //System.out.println("Sorted array: " + array);
        //Index pointers
        int start = 0;
        int middle;
        int end = array.size() - 1;

        while (start <= end) {

            middle = (start + end) / 2;

            //System.out.println("Searching element in position: " + middle);
            if (array.get(middle).contains(name)) { //compare the name to the variable

                return array + " found at index: " + middle;

            } else if (array.get(middle).get(3).compareTo(name) < 0) { //if the name is smaller than the middle, go left

                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return "Element not found";

    }
    
    public List<ArrayList<String>> listBooksBorrowed() {

        List<ArrayList<String>> myList = new ArrayList<>();

        try {
            //create a buffered Reader and Writer
            BufferedReader myFile = new BufferedReader(new FileReader("borrows.txt"));

            //create a variable to read the next line in the Data file...
            String text = myFile.readLine();
            //and starts at the second line of the file because the first has no significant data
            text = myFile.readLine();

            // while loop to run until "text" can read nothing more in the Data file
            while (text != null) {
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

        } catch (Exception e) {
            System.out.println("Error reading the file");

            return null;
        }
    }


}
