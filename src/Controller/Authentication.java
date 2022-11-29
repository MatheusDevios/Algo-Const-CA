/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author matheusdiniz
 * @author carloswilker
 */
public class Authentication {
    
    String user_name = "";
    String login = "cct";
    String password = "";
    String passwordCheck = "LibraryCCT2022";

    public boolean login (String username, String password){

        this.user_name = username;
        this.password = password;

        //Checking the validation of the input
        if(username.equals(login) && password.equals(passwordCheck)){
            //printing output
            System.out.println("\nAuthentication Successful.");
            return true;
        }
        else {
            System.out.println("\nUser name or Password invalid.");
            return false;
        }
    }
}
