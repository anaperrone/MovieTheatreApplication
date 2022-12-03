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

    public OrdinaryUser(){}

    public void addEmail(String e){
        this.email = e;
    }

    public void addCard(int cvv, String cardNumber, LocalDate expiry, String name){
        Card c = new Card(expiry, cardNumber, cvv, name);
        this.card = c;
    }
}
