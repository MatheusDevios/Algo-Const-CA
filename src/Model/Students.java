/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author matheusdiniz
 */
public class Students {
    
    private String studentID;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String adress;

    public Students(String studentID, String firstName, String lastName, String email, String gender, String adress) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.adress = adress;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return "StudentID: " + studentID + ",\t Name: " + firstName + " " + lastName + ",\t email: " + email + ",\t gender: " + gender + ",\t adress: " + adress;
    }
    
    public String toStringUnic() {
        return "\nStudentID: " + studentID + "\nName: " + firstName + " " + lastName + "\nemail: " + email + "\ngender: " + gender + "\nadress: " + adress;
    }
}
