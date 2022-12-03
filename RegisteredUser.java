/*
* RegisteredUser.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/
import java.util.*;
import java.time.*;

public class RegisteredUser extends OrdinaryUser{
    private ArrayList<Card> cards; 
    private Address address;
    private LoginServer instance;
    private String username;
    private String password;
    private String name;
    private DataBase d;

    public RegisteredUser(){
        super();
        cards = new ArrayList<Card>();
        instance = LoginServer.getOnlyInstance();
    }

    public boolean checkUsername(String username, String password){
        return instance.checkUsername(username, password);
    }

    public boolean grantAccess()
    {
        return d.grantAccess(username, password);
    }

    public void setAll(String username, String password, LocalDate expiry, String cardNumber, int cvv, String name, String street, int number, String city, String country, String postal)
    {
        setUser(username, password);
        setCard(expiry, cardNumber, cvv, name);
        setAddress(street, number, city, country, postal);
        
        d = new DataBase();
        d.addAddress(street, number, city, country, postal);
        d.addRegisteredUser(username, password, number, street);
        d.addCard(username, expiry, cardNumber, cvv, name);
        d.close();
        
    }

    public void setUser(String username, String password){
        this.username = username;
        this.password = password;

    }

    public void setCard(LocalDate expiry, String cardNumber, int cvv, String name){
        Card card = new Card(expiry, cardNumber, cvv, name);
        cards.add(card);
    }

    public void setAddress(String street, int number, String city, String country, String postal){
        Address add = new Address(street, number, city, country, postal);
        this.address = add;
    }

    public void remove(Card card){
        String num = card.getCardNumber();
        for(int i = 0; i< cards.size(); i++){
            if(cards.get(i).getCardNumber() == num){
                cards.remove(i);
            }
        }
    }

    public void addCard(Card card){
        cards.add(card);
    }
}
