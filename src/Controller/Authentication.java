/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author matheusdiniz
 */
public class Authentication {
    
    String user_name = "cct";
    String password = "LibraryCCT2022";

    public boolean login (String username, String password){

        this.user_name = username;
        this.password = password;

        //Checking the validation of the input
        if(username.equals("cct") && password.equals("LibraryCCT2022")){
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
