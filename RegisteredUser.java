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

    //default constructor which invokes constructor of parent class, OrdinaryUser
    //and creates a new empty arraylist for cards as well as an instance of singleton
    //pattern; LoginServer
    public RegisteredUser(DataBase database){
        super();
        this.d = database;
        cards = new ArrayList<Card>();
        instance = LoginServer.getOnlyInstance();
        instance.setDatabase(database);
    }

    /* 
    * public method which checks if the current username and password already
    * exist in the database or not. Returns a boolean: true if the username is
    * available to use and false if it already exists
    */
    public boolean checkUsername(String username, String password){
        return instance.checkUsername(username, password);
    }

    /*
     * public method which takes in a username and password and checks both against
     * the usernames and passwords in the database and checks if the 
     * inputted combination is valid. Returns a boolean: true if the username and
     * password match one found in the database and false otherwise
     */
    public boolean grantAccess(String username, String password)
    {
        return d.grantAccess(username, password);
    }

    /*
     * public method which takes in all the necessary information to create and account
     * calls individual setters to set all the information and then adds the 
     * info to the database
     */
    public void setAll(String username, String password, LocalDate expiry, String cardNumber, int cvv, String name, String street, int number, String city, String country, String postal)
    {
        setUser(username, password);
        setCard(expiry, cardNumber, cvv, name);
        setAddress(street, number, city, country, postal);
        
        d.addAddress(street, number, city, country, postal);
        d.addRegisteredUser(username, password, number, street);
        d.addCard(username, expiry, cardNumber, cvv, name);
        d.close();
        
    }

    /*
     * public method which sets the username and password
     */
    public void setUser(String username, String password){
        this.username = username;
        this.password = password;

    }

    /*
     * public method which takes in all the information of a card and makes a new
     * card object and appends that to the arraylist of cards for this account
     */
    public void setCard(LocalDate expiry, String cardNumber, int cvv, String name){
        Card card = new Card(expiry, cardNumber, cvv, name);
        cards.add(card);
    }

    /*
     * public method which sets the address for a person, creates a new address object
     * for this person
     */
    public void setAddress(String street, int number, String city, String country, String postal){
        Address add = new Address(street, number, city, country, postal);
        this.address = add;
    }

    /*
     * public method to remove a card from the arraylist of cards for this account
     */
    public void remove(Card card){
        String num = card.getCardNumber();
        for(int i = 0; i< cards.size(); i++){
            if(cards.get(i).getCardNumber() == num){
                cards.remove(i);
            }
        }
        //add a remove card method for db?
    }
}
