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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheusdiniz
 */
public class Data {
    
    public  void returnBook(String[] returns) throws IOException{
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("returnList.txt", true));
            bw.write(returns[0] +","+returns[1]+","+returns[2]+"\n");
            bw.close();
        }catch(IOException e){
            System.out.println("Error!");
        }
        System.out.println("\nBook returned!");
    }
    
    public  void borrowBook(String[] borrows) throws IOException{
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("borrowList.txt", true));
            bw.write(borrows[0] +","+borrows[1]+","+borrows[2]+"\n");
            bw.close();
        }catch(IOException e){
            System.out.println("Error!");
        }
        System.out.println("\nBook borrowed!");
    }
    
    public  void bookQueue(String[] borrows) throws IOException{
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("queueList.txt", true));
            bw.write(borrows[0] +","+borrows[1]+","+borrows[2]+"\n");
            bw.close();
        }catch(IOException e){
            System.out.println("Error!");
        }
        System.out.println("\nYou were added to the waiting list!");
    }
    
    public List<Books> loadBooks() throws FileNotFoundException {
        ArrayList<Books> objectList = new ArrayList<Books>();
        FileInputStream bookDataFile = new FileInputStream("MOCK_DATA.txt");
        String line;

        try (BufferedReader breader = new BufferedReader(new InputStreamReader(bookDataFile))) {
            line = breader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                objectList.add(new Books(parts[0], parts[1], parts[2], parts[3], parts[4]));
                line = breader.readLine();
            }

        } catch (IOException e) {

        }
        return objectList;
    }
    public ArrayList<Students> loadStudents() throws FileNotFoundException {
        ArrayList<Students> objectList = new ArrayList<Students>();
        FileInputStream bookDataFile = new FileInputStream("MOCK_STUDENTS.txt");
        String line;

        try (BufferedReader breader = new BufferedReader(new InputStreamReader(bookDataFile))) {
            line = breader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                objectList.add(new Students(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                line = breader.readLine();
            }

        } catch (IOException e) {

        }
        return objectList;
    }
    public ArrayList<Queue> loadQueue() throws FileNotFoundException {
        ArrayList<Queue> objectList = new ArrayList<Queue>();
        FileInputStream bookDataFile = new FileInputStream("queueList.txt");
        String line;

        try (BufferedReader breader = new BufferedReader(new InputStreamReader(bookDataFile))) {
            line = breader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                objectList.add(new Queue(parts[0], parts[1], parts[2]));
                line = breader.readLine();
            }

        } catch (IOException e) {

        }
        return objectList;
    }
    public ArrayList<Returns> loadReturns() throws FileNotFoundException {
        ArrayList<Returns> objectList = new ArrayList<Returns>();
        FileInputStream bookDataFile = new FileInputStream("returnList.txt");
        String line;

        try (BufferedReader breader = new BufferedReader(new InputStreamReader(bookDataFile))) {
            line = breader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                objectList.add(new Returns(parts[0], parts[1], parts[2]));
                line = breader.readLine();
            }

        } catch (IOException e) {

        }
        return objectList;
    }
    public ArrayList<Borrows> loadBorrows() throws FileNotFoundException {
        ArrayList<Borrows> objectList = new ArrayList<Borrows>();
        FileInputStream bookDataFile = new FileInputStream("borrowList.txt");
        String line;

        try (BufferedReader breader = new BufferedReader(new InputStreamReader(bookDataFile))) {
            line = breader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                objectList.add(new Borrows(parts[0], parts[1], parts[2]));
                line = breader.readLine();
            }

        } catch (IOException e) {

        }
        return objectList;
    }
    
}
