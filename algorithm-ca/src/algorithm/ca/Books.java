/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.ca;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Carlos Wilker
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

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "# BOOK # ID: " + getId() + ", Title: " + getBookTitle() + ", Author: " + getAuthorFirstName() + getAuthorLastName() + ", Genre: " + getGenre() + "\n";
    }

}
