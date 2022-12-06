/*
* RegisteredUser.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

package User;
import Movies.*;
import GUI.*;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class RegisteredUser extends OrdinaryUser{
    private ArrayList<Card> cards; 
    private Address address;
    private LoginServer instance;
    private String username;
    private String password;
    private String name;
    private DataBase d;
    private LocalDate signUp;

    //Constructor which invokes constructor of parent class, OrdinaryUser
    //and creates a new empty arraylist for cards as well as an instance of singleton
    //pattern; LoginServer
    public RegisteredUser(DataBase database){
        super(database);
        this.d = database;
        cards = new ArrayList<Card>();
        instance = LoginServer.getOnlyInstance();
        instance.setDatabase(database);
    }

    // /* 
    // * public method which checks if the current username and password already
    // * exist in the database or not. Returns a boolean: true if the username is
    // * available to use and false if it already exists
    // */
    // public boolean checkUsername(String username, String password){
    //     return instance.checkUsername(username, password);
    // }

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

    public void annualFee()
    {
        //if it has been a whole number of years since sign up, prompt for annual fee. 
        signUp = d.getRegistrationDate(username);   //Get the date the user signed up
        LocalDate year = LocalDate.now();           //Get today's date 
        LocalDate signup = signUp.plusYears(1);     //Add a year to their signUp date 
        if (signup.compareTo(year) >= 0)            //If it has been a year or more since they signed up. prompt for payment 
        {
            d.setRegistrationDate(signup, username);          //Set signup date to todays date 
            Email email = new Email();
            email.sendEmail(username, "Hello user, \nYou are due to pay the annual fee of $20.00 now. Please pay through your bank.", "Cinemama- Annual Fee Payment");                          //return false to say that registered user hasn't paid annual fee and to prompt them to pay fee
        }

    }

    /*
     * public method which takes in all the necessary information to create and account
     * calls individual setters to set all the information and then adds the 
     * info to the database
     */
    public String setAll(String username, String password, String expiry, String cardNumber, int cvv, String name, String street, int number, String city, String country, String postal)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy"); 
        YearMonth expMonth;
        try{
            expMonth = YearMonth.parse(expiry, formatter);
        }
        catch(Exception ex){
            return "ERROR: Invalid expiry date. Please re-enter.";
        }
        LocalDate exp = expMonth.atDay(1);
        boolean cardValidated = setCard(exp, cardNumber, cvv, name);
        if(cardValidated == false){
            return "ERROR: Invalid card information. Please try again";
        }

        boolean addressValidated = setAddress(street, number, city, country, postal);
        if(addressValidated == false){
            return "ERROR: Account already created for this address.";
        }
        
        boolean usernameValidated = setUser(username, password);
        if(usernameValidated == false){
            return "ERROR: Invalid username. Please select another";
        }

        d.addAddress(street, number, city, country, postal);
        d.addCard(username, exp, cardNumber, cvv, name);
        d.addRegisteredUser(username, password, number, street, cardNumber, cvv);
        
        Email email = new Email();
        email.sendEmail(username, "Hello user, \nYour account has been created successfully. You must now pay the annual fee of $20.00 through your bank.", "Cinemama - Account Creation and Annual Fee Payment");

        return "Account created successfully." ;
    }

    /*
     * public method which sets the username and password
     */
    public boolean setUser(String username, String password){
        boolean value = instance.checkUsername(username, password);
        if(value){
            this.username = username;
            this.password = password;
            return true;
        }
        return false;
    }

    /*
     * public method which takes in all the information of a card and makes a new
     * card object and appends that to the arraylist of cards for this account
     * after checking if the card is valid. Returns true if valid, false otherwise
     */
    public boolean setCard(LocalDate expiry, String cardNumber, int cvv, String name){
        Card card = new Card();
        card.setFields(expiry, cardNumber, cvv, name);
        if(card.verifyCard(cvv, cardNumber)){
            cards.add(card);
            this.name = name;
            if(d.checkCard(cvv, cardNumber)){
                return true;
            }
            
        }
        return false;
    }

    /*
     * public method which sets the address for a person, creates a new address object
     * for this person
     */
    public boolean setAddress(String street, int number, String city, String country, String postal){
        boolean validAddress = d.validateAddress(street, number);
        if(validAddress){
            Address add = new Address(street, number, city, country, postal);
            this.address = add;
            return true;
        }
        return false;
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

    public String getCardNumber()
    {
        return cards.get(0).getCardNumber();
    }

    public String getEmail()
    {
        return username;
    }

    public String getName()
    {
        return name;
    }
}
