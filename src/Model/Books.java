/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author matheusdiniz
 */
public class Books {
    
    private String id;
    private String authorFirstName;
    private String authorLastName;
    private String bookTitle;
    private String genre;

    public Books(String bookID, String authorFirstName, String authorLastName, String bookTitle, String genre) {
        this.id = bookID;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.bookTitle = bookTitle;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object ref) {
        Books b = (Books) ref;
        if ((this.id == b.id) && (this.bookTitle.equalsIgnoreCase(b.bookTitle)) && (this.authorFirstName.equalsIgnoreCase(b.authorFirstName))) {
            return true;
        } else {
            return false;
        }
    }


    public String getId() {
        return id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "# BOOK # ID: " + getId() + ", Title: " + getBookTitle() + ", Author: " + getAuthorFirstName() + " " + getAuthorLastName() + ", Genre: " + getGenre() + "\n";
    }

}
