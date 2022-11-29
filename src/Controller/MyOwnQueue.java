package Controller;


import Model.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matheusdiniz
 * @author carloswilker
 */
public class MyOwnQueue {
    
    private ArrayList<Queue> array = new ArrayList<Queue>();
//    String[] data = new String[10];
    
    public MyOwnQueue () {}
    

    public boolean Enqueue(Queue newElement) {
        try {
            return this.array.add(newElement);
        } catch (Exception e) {
            return false;
        }
    }

    public Queue Dequeue() {
        try {
            return this.array.remove(0);
        } catch (Exception e) {
            System.out.println("There is no item on the array");
            return null;
        }
    }

    public Queue First() {
        try {
            return this.array.get(0);
        } catch (Exception e) {
            System.out.println("There is no element");
            return null;
        }
    }

    public Queue Last() {
        try {
            return this.array.get(this.array.size()-1);
        } catch (Exception e) {
            System.out.println("There is no element");
            return null;
        }
    }

    public int size() {
        return this.array.size();
    }

    public boolean isEmpty() {
        return this.array.isEmpty();
    }
    
    
    @Override
    public String toString() {
        String newArray = "";
        if(!this.array.isEmpty()) {
            for (int i = 0; i < this.array.size(); i++) {
            newArray += "[" + this.array.get(i) + "],";
        }
            return newArray;
        }
        return "There is no item on the Queue.";
    }
}