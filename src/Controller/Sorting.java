/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Books;
import Model.Students;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheusdiniz
 */
public class Sorting {
    
                //******* BOOK SORTING *************
    //function that divides the main List into subLists 
    public List<Books> mergeSortBook(List<Books> array, int option) {

        //Code goes here
        List<Books> arraySorted = new ArrayList<>();
        
        //checks if the array has only one item
        if (array.size() == 1) {
            return array;
        }
        //gets the lenght of the list and the middle reference of it
        int length = array.size();
        int middle = length/2;
        //creates 2 subLists from the main list with the references above.
        List<Books> left = array.subList(0, middle);
        List<Books> right = array.subList(middle,length);
        
        //call the recursive function to first divide in half the left part until it gets to the last number and then...
        //starts sorting it. It does that first for the left side of the main array and then for the right side.
        arraySorted = mergeBook(mergeSortBook(left, option), mergeSortBook(right, option), option);
        return arraySorted;
    }

    //function that actually sorts the array depending on the option chosen.
    public List<Books> mergeBook(List<Books> left, List<Books> right, int option) {

        //Code goes here
        List<Books> array = new ArrayList<>();
        //gets a initial index for both sides
        int leftIndex = 0;
        int rightIndex = 0;
        //depending on the option chosen it does the sorting by case 1(Name) or case 2(ID)
        switch (option){
            //sorts by Author
            case 1:
                while (leftIndex < left.size() && rightIndex < right.size()) {
                    //checks if the first name on the left side comes first than the first name on the right side
                    if (left.get(leftIndex).getAuthorFirstName().compareTo(right.get(rightIndex).getAuthorFirstName()) < 0 ) {
                        //adds the left item because the first name from the left side to the new sorted List
                        array.add(left.get(leftIndex));
                        leftIndex++;
                        //checks if the first name on the left side is eqaul to the first name on the right side
                    } else if (left.get(leftIndex).getAuthorFirstName().compareTo(right.get(rightIndex).getAuthorFirstName()) == 0 ) {
                        //then if the first names are equal, it checks if the surname on the left side comes first than the surname on the right side
                        if (left.get(leftIndex).getAuthorLastName().compareTo(right.get(rightIndex).getAuthorLastName()) < 0 ) {
                            //adds the left item due to the surname coming first if the first name is the same.
                            array.add(left.get(leftIndex));
                            leftIndex++;
                        } else {
                            //if the right surname comes first, it adds the right item to the sorted list.
                            array.add(right.get(rightIndex));
                            rightIndex++;
                        }
                    //if the first name from the right side comes firts, it adds the right item to the sorted list.
                    } else {
                        array.add(right.get(rightIndex));
                        rightIndex++;
                    }
                }
                //if I still have left items and none right ones, then it adds the left item to the sorted List
                while(leftIndex < left.size()){
                    array.add(left.get(leftIndex));
                    leftIndex++;          
                }
                //if I still have right items and none left ones, then it adds the left item to the sorted List
                while(rightIndex < right.size()){
                    array.add(right.get(rightIndex));
                    rightIndex++;            
                }
                break;
            //sorts by TITLE
            case 2:
                while (leftIndex < left.size() && rightIndex < right.size()) {
                    //compares the ID from the first and second item and if the left Title comes first
                    if (left.get(leftIndex).getBookTitle().compareTo(right.get(rightIndex).getBookTitle()) < 0 ) {
                        //it adds the first item to the sorted list
                        array.add(left.get(leftIndex));
                        leftIndex++;
                    //if the right item comes first then it adds the right item to the sorted list
                    } else {
                        array.add(right.get(rightIndex));
                        rightIndex++;
                    }
                }
                //if I still have left items and none right ones, then it adds the left item to the sorted List
                while(leftIndex < left.size()){
                    array.add(left.get(leftIndex));
                    leftIndex++;          
                }
                //if I still have right items and none left ones, then it adds the left item to the sorted List
                while(rightIndex < right.size()){
                    array.add(right.get(rightIndex));
                    rightIndex++;            
                }
                break;
            //if users chooses an diferent option, shows an error message.
            default:
                System.out.println("Sorry, there is no such option. Please, choose either option 1 or 2.");
                break;
        } 
 
        return array;
    }
                //******* STUDENT SORTING *************
    //function that divides the main List into subLists 
    public List<Students> mergeSortStudent(List<Students> array, int option) {

        //Code goes here
        List<Students> arraySorted = new ArrayList<>();
        
        //checks if the array has only one item
        if (array.size() == 1) {
            return array;
        }
        //gets the lenght of the list and the middle reference of it
        int length = array.size();
        int middle = length/2;
        //creates 2 subLists from the main list with the references above.
        List<Students> left = array.subList(0, middle);
        List<Students> right = array.subList(middle,length);
        
        //call the recursive function to first divide in half the left part until it gets to the last number and then...
        //starts sorting it. It does that first for the left side of the main array and then for the right side.
        arraySorted = mergeStudent(mergeSortStudent(left, option), mergeSortStudent(right, option), option);
        return arraySorted;
    }

    //function that actually sorts the array depending on the option chosen.
    public List<Students> mergeStudent(List<Students> left, List<Students> right, int option) {

        //Code goes here
        List<Students> array = new ArrayList<>();
        //gets a initial index for both sides
        int leftIndex = 0;
        int rightIndex = 0;
        //depending on the option chosen it does the sorting by case 1(Name) or case 2(ID)
        switch (option){
            //sorts by NAME
            case 1:
                while (leftIndex < left.size() && rightIndex < right.size()) {
                    //checks if the first name on the left side comes first than the first name on the right side
                    if (left.get(leftIndex).getFirstName().compareTo(right.get(rightIndex).getFirstName()) < 0 ) {
                        //adds the left item because the first name from the left side to the new sorted List
                        array.add(left.get(leftIndex));
                        leftIndex++;
                        //checks if the first name on the left side is eqaul to the first name on the right side
                    } else if (left.get(leftIndex).getFirstName().compareTo(right.get(rightIndex).getFirstName()) == 0 ) {
                        //then if the first names are equal, it checks if the surname on the left side comes first than the surname on the right side
                        if (left.get(leftIndex).getLastName().compareTo(right.get(rightIndex).getLastName()) < 0 ) {
                            //adds the left item due to the surname coming first if the first name is the same.
                            array.add(left.get(leftIndex));
                            leftIndex++;
                        } else {
                            //if the right surname comes first, it adds the right item to the sorted list.
                            array.add(right.get(rightIndex));
                            rightIndex++;
                        }
                    //if the first name from the right side comes firts, it adds the right item to the sorted list.
                    } else {
                        array.add(right.get(rightIndex));
                        rightIndex++;
                    }
                }
                //if I still have left items and none right ones, then it adds the left item to the sorted List
                while(leftIndex < left.size()){
                    array.add(left.get(leftIndex));
                    leftIndex++;          
                }
                //if I still have right items and none left ones, then it adds the left item to the sorted List
                while(rightIndex < right.size()){
                    array.add(right.get(rightIndex));
                    rightIndex++;            
                }
                break;
            //sorts by ID
            case 2:
                while (leftIndex < left.size() && rightIndex < right.size()) {
                    //compares the ID from the first and second item and if the left ID comes first
                    if (left.get(leftIndex).getStudentID().compareTo(right.get(rightIndex).getStudentID()) < 0 ) {
                        //it adds the first item to the sorted list
                        array.add(left.get(leftIndex));
                        leftIndex++;
                    //if the right item comes first then it adds the right item to the sorted list
                    } else {
                        array.add(right.get(rightIndex));
                        rightIndex++;
                    }
                }
                //if I still have left items and none right ones, then it adds the left item to the sorted List
                while(leftIndex < left.size()){
                    array.add(left.get(leftIndex));
                    leftIndex++;          
                }
                //if I still have right items and none left ones, then it adds the left item to the sorted List
                while(rightIndex < right.size()){
                    array.add(right.get(rightIndex));
                    rightIndex++;            
                }
                break;
            //if users chooses an diferent option, shows an error message.
            default:
                System.out.println("Sorry, there is no such option. Please, choose either option 1 or 2.");
                break;
        } 
 
        return array;
    }
    
}
