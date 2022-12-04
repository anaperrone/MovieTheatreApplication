/*
* OrdinaryUser.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/
import java.util.*;
import java.time.*;

abstract class OrdinaryUser { //should this be abstract? no objects of it.
    private String email;
    private Card card;
    private LocalDate purchaseDate;

    //defualt constructor
    public OrdinaryUser(){}

    //method to store the email of the ordinary user for the time being
    public void addEmail(String e){
        this.email = e;
        //should we send this to the db?

    }

    //add a card for the user by creating a new card object
    public void addCard(int cvv, String cardNumber, LocalDate expiry, String name){
        Card c = new Card();
        c.setFields(expiry, cardNumber, cvv, name);
        this.card = c;
    }
}
