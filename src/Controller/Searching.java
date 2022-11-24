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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheusdiniz
 */
public class Searching {
    
    public Books binarySearchBooks(List<Books> array, String target, int option){
        
	if (array.size() == 0) return null;
	
	int left = 0;
	int right = array.size() - 1;
        String result = "";

	while (left <=right) {
		int mid = (left+right) / 2; //2
                switch(option){
                    case 1:
                        result = array.get(mid).getAuthorFirstName().toLowerCase() + " " + array.get(mid).getAuthorLastName().toLowerCase();
                        break;
                    case 2:
                        result = array.get(mid).getBookTitle().toLowerCase();
                        break;
                }

		if (result.contains(target)) return array.get(mid);
		
		if (result.compareTo(target) < 0) {
			left = mid + 1;
		} else { 
			right = mid - 1;
		}
	}
	return null;
    }
    public Students binarySearchStudent(List<Students> array, String target, int option){
        
	if (array.size() == 0) return null;
	
	int left = 0;
	int right = array.size() - 1;
        String result = "";

	while (left <=right) {
		int mid = (left+right) / 2; //2
                switch(option){
                    case 1:
                        result = array.get(mid).getFirstName().toLowerCase() + " " + array.get(mid).getLastName().toLowerCase();
                        break;
                    case 2:
                        result = array.get(mid).getStudentID()+"";
                        break;
                }

		if (result.equalsIgnoreCase(target)) return array.get(mid);
		
		if (result.compareTo(target) < 0) {
			left = mid + 1;
		} else { 
			right = mid - 1;
		}
	}
	return null;
    }
    
    
    public String queueSearchBorrow(List<Borrows> array, String target) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getBookTitle().equalsIgnoreCase(target)) return array.get(i).toString();
        }
        return "";
    }
    public String queueSearchReturn(List<Queue> array, String target) {
        for (Queue item : array) {
            if (item.getBookTitle().equalsIgnoreCase(target)) return item.toString();
        }
        return "";
    }
    
}
