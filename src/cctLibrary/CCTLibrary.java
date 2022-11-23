/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cctLibrary;

import Controller.GetMenuOptions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheusdiniz
 */
public class CCTLibrary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        GetMenuOptions start = new GetMenuOptions();
        start.getMenuOptions();
        
    }  
    
//    public CCTLibrary() {
//    
//        //creates the ArrayList to store the initial data from the file.
//        List<ArrayList<String>> myList = new ArrayList<>(); 
//        
//        try {
//            //create a buffered Reader and Writer
//            BufferedReader myFile = new BufferedReader(new FileReader("MOCK_DATA.txt"));
//
//            //create a variable to read the next line in the Data file...
//            String text = myFile.readLine();
//            //and starts at the second line of the file because the first has no significant data
//            text = myFile.readLine();
//            // while loop to run until "text" can read nothing more in the Data file
//            while(text != null){
//                ArrayList<String> mySubList = new ArrayList<>(); 
//                String[] result = text.split(",");
//                
//                //loop to populate the list of each book
//                for (int i = 0; i < result.length; i++) {
//                    // add to the array list the line read from the file
//                    mySubList.add(result[i]);
//                }
//                //Adds the arrayList of each book data to the main List
//                myList.add(mySubList);
//                // reads the next line of the Data file
//                text = myFile.readLine(); 
//            }
//            
//            //option that will store if it will be sorted by name or ID
//            int option = 2;
//            
//            //creating a new sorted List
//            List<ArrayList<String>> mySortedList = new ArrayList<>();
//            //calling the funcition to sort the list regarding to the option chosen
//            mySortedList = mergeSort(myList, option);
//            
//            //call function to print sorted list
//            System.out.println("Sorted: ");
//            printArray(mySortedList);
//            
//            System.out.println("Search: ");
//            System.out.println(binarySearch(mySortedList, "The Bone Snatcher"));
//            
//        // catches some error if for some reason the program can't read from or write to its respectives files    
//        }catch(Exception e){
//            System.out.println("Error reading from the file or Unable to write to file: Clean.txt");
//        }
//        
//    }
//    
//                //******* SORTING *************
//    //function that divides the main List into subLists 
//    public List<ArrayList<String>> mergeSort(List<ArrayList<String>> array, int option) {
//
//        //Code goes here
//        List<ArrayList<String>> arraySorted = new ArrayList<>();
//        
//        //checks if the array has only one item
//        if (array.size() == 1) {
//            return array;
//        }
//        //gets the lenght of the list and the middle reference of it
//        int length = array.size();
//        int middle = length/2;
//        //creates 2 subLists from the main list with the references above.
//        List<ArrayList<String>> left = array.subList(0, middle);
//        List<ArrayList<String>> right = array.subList(middle,length);
//        
//        //call the recursive function to first divide in half the left part until it gets to the last number and then...
//        //starts sorting it. It does that first for the left side of the main array and then for the right side.
//        arraySorted = merge(mergeSort(left, option), mergeSort(right, option), option);
//        return arraySorted;
//    }
//
//    //function that actually sorts the array depending on the option chosen.
//    public List<ArrayList<String>> merge(List<ArrayList<String>> left, List<ArrayList<String>> right, int option) {
//
//        //Code goes here
//        List<ArrayList<String>> array = new ArrayList<>();
//        //gets a initial index for both sides
//        int leftIndex = 0;
//        int rightIndex = 0;
//        //depending on the option chosen it does the sorting by case 1(Name) or case 2(ID)
//        switch (option){
//            //sorts by NAME
//            case 1:
//                while (leftIndex < left.size() && rightIndex < right.size()) {
//                    //checks if the first name on the left side comes first than the first name on the right side
//                    if (left.get(leftIndex).get(1).compareTo(right.get(rightIndex).get(1)) < 0 ) {
//                        //adds the left item because the first name from the left side to the new sorted List
//                        array.add(left.get(leftIndex));
//                        leftIndex++;
//                        //checks if the first name on the left side is eqaul to the first name on the right side
//                    } else if (left.get(leftIndex).get(1).compareTo(right.get(rightIndex).get(1)) == 0 ) {
//                        //then if the first names are equal, it checks if the surname on the left side comes first than the surname on the right side
//                        if (left.get(leftIndex).get(2).compareTo(right.get(rightIndex).get(2)) < 0 ) {
//                            //adds the left item due to the surname coming first if the first name is the same.
//                            array.add(left.get(leftIndex));
//                            leftIndex++;
//                        } else {
//                            //if the right surname comes first, it adds the right item to the sorted list.
//                            array.add(right.get(rightIndex));
//                            rightIndex++;
//                        }
//                    //if the first name from the right side comes firts, it adds the right item to the sorted list.
//                    } else {
//                        array.add(right.get(rightIndex));
//                        rightIndex++;
//                    }
//                }
//                //if I still have left items and none right ones, then it adds the left item to the sorted List
//                while(leftIndex < left.size()){
//                    array.add(left.get(leftIndex));
//                    leftIndex++;          
//                }
//                //if I still have right items and none left ones, then it adds the left item to the sorted List
//                while(rightIndex < right.size()){
//                    array.add(right.get(rightIndex));
//                    rightIndex++;            
//                }
//                break;
//            //sorts by ID
//            case 2:
//                while (leftIndex < left.size() && rightIndex < right.size()) {
//                    //compares the ID from the first and second item and if the left ID comes first
//                    if (left.get(leftIndex).get(3).compareTo(right.get(rightIndex).get(3)) < 0 ) {
//                        //it adds the first item to the sorted list
//                        array.add(left.get(leftIndex));
//                        leftIndex++;
//                    //if the right item comes first then it adds the right item to the sorted list
//                    } else {
//                        array.add(right.get(rightIndex));
//                        rightIndex++;
//                    }
//                }
//                //if I still have left items and none right ones, then it adds the left item to the sorted List
//                while(leftIndex < left.size()){
//                    array.add(left.get(leftIndex));
//                    leftIndex++;          
//                }
//                //if I still have right items and none left ones, then it adds the left item to the sorted List
//                while(rightIndex < right.size()){
//                    array.add(right.get(rightIndex));
//                    rightIndex++;            
//                }
//                break;
//            //if users chooses an diferent option, shows an error message.
//            default:
//                System.out.println("Sorry, there is no such option. Please, choose either option 1 or 2.");
//                break;
//        } 
// 
//        return array;
//    }
//    
//    //function that prints the List.
//    public void printArray(List<ArrayList<String>> array) {
//        for (int i = 0; i < array.size(); i++) {
//            System.out.println(array.get(i));
//        }
//    }
//    
//    public String binarySearch(List<ArrayList<String>> array, String target){
//        
//	if (array.size() == 0) return "Your List is empty.";
//	
//	int left = 0;
//	int right = array.size() - 1;
//        String result = "";
//
//	while (left <=right) {
//		int mid = (left+right) / 2; //2
////                result = array.get(mid).get(1) + " " + array.get(mid).get(2);
//                result = array.get(mid).get(3);
//
//		if (result.contains(target)) return array.get(mid).toString();
//		
//		if (result.compareTo(target) < 0) {
//			left = mid + 1;
//		} else { 
//			right = mid - 1;
//		}
//	}
//	return "There is no Book with that name.";
//    }
//  
}