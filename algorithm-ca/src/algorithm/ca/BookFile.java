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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlo
 */
public class BookFile implements LibraryInterface{
    
    public ArrayList<Books> loadBookDataFile() throws FileNotFoundException {

        ArrayList<Books> books = new ArrayList<Books>();
        FileInputStream bookDataFile = new FileInputStream("MOCK_DATA.txt");
        String line;

        try  {
            BufferedReader breader = new BufferedReader(new InputStreamReader(bookDataFile));
            line = breader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                books.add(new Books ((parts[0]),parts[1],parts[2],parts[3], parts[4]));
                line = breader.readLine();
            }

        } catch (IOException e) {

            System.out.println("No found");
        } catch (ArrayIndexOutOfBoundsException ae){
            System.out.println("Index wrong");
        }
        return books;
    }
    
    // 1 - Get a book by title
    public void getBookTitle(ArrayList<Books> book, String title) {
        boolean result = false;
        for (Books bk : book) {
            if (bk.getBookTitle().contains(title)) {
                System.out.println(bk.toString());
                result = true;

            }
        }

        if (result == false) {
            System.out.println("Title not found.");
        }

    }
    
    // 2 - Get a book by author first name
        public void getBookAuthor(ArrayList<Books> book, String author) {
        boolean result = false;
        //String authorName = authorFirstName + authorLastName;
        for (Books bk : book) {
            if (bk.getAuthorFirstName().contains(author)) {
                System.out.println(bk.toString());
                result = true;
            }
        }

        if (result == false) {
            System.out.println("Author not found.");
        }

    }

    @Override
    public void borrowBook(String[] borrows) {
    }
    
    public List<ArrayList<String>> readingBorrowFile() {

        List<ArrayList<String>> myList = new ArrayList<>();

        try {
            //create a buffered Reader and Writer
            BufferedReader myFile = new BufferedReader(new FileReader("borrow.txt"));

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

        } catch (IOException e) {
            System.out.println("Not found");

        }
        System.out.println(array);

    }

    
}
