/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cctLibrary;

import Controller.Authentication;
import Controller.GetMenuOptions;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author matheusdiniz
 * @author carloswilker
 */
public class CCTLibrary {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        boolean isLogged = false;
        Scanner scanner = new Scanner(System.in);
        GetMenuOptions start = new GetMenuOptions();
        Authentication auth = new Authentication();
        
        do {
            System.out.println("Login: ");
            String login = scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.nextLine();
            
            if (auth.login(login, password)) {
                start.getMenuOptions();
                isLogged = true;
            }
        } while (!isLogged);
        
    }  
}