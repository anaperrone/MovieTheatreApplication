/*
* Payment.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

package Movies;
import User.*;
import GUI.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Payment {
    private Card card;
    
    public Payment() {}

    public Payment(Card card)
    {
        this.card = card;
    }

    public String proceed(String expiry, String cardNumber, int cvv) {
        Card card = new Card();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy"); 
        YearMonth expMonth;
        try{
            expMonth = YearMonth.parse(expiry, formatter);
        }
        catch(Exception ex){
            return "ERROR: Invalid expiry date. Please re-enter.";
        }
        if(card.verifyCard(cvv, cardNumber) == true) {
            return "Payment successful.";
        } else {
            return "ERROR: Invalid card information. Please try again";
        }
    }
    
}
