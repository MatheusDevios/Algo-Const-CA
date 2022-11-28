package View;

public class Authentication {

    String user_name = "cct";
    String password = "LibraryCCT2022";

    public void login (String username, String password){
 
        this.user_name = username;
        this.password = password;

    //Checking the validation of the input
    if(username.equals("cct") && password.equals("LibraryCCT2022")){

        //printing output
        System.out.println("Authentication Successful");
    }
    else {
        System.out.println("User name or Password invalid");
    }
}
    
}
