/*
* Card.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

import java.util.regex.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.*;

public class Card {
    private String expiry;
    private String cardNumber;
    private int cvv;
    private String name;
    private String CARD_REGEX = "[0-9]{16}";
    private Pattern CARD_PATTERN = Pattern.compile(CARD_REGEX);

    /*
     * Constructor for Card which takes in an expiry LocalDate, String card number integer cvv 
     * and String name. Returns noting 
     */
    public Card(LocalDate e, String n, int c, String name) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM"); 
        this.expiry = formatter.format(e);
        this.cardNumber = n;
        this.cvv = c;
        this.name = name;
    }

    /*
     * public method to verify that user has input correct card information before proceeding to make payment 
    */
    public boolean verifyCard(int cvv, String cardNumber) {
        
        if(cvv <= 999 || cvv >= 100) {
            return true;
        }
        
        Matcher cardMatcher = CARD_PATTERN.matcher(cardNumber);
        if(cardMatcher.find()) {
            return true;
        }
        
        return false;
    }

    /*
     * public method to process payment after user has put in all correct information about card
    */
    public boolean doPayment() {
        return true;
    }

    public String getCardNumber(){
        return cardNumber;
    }
}
