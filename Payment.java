/*
* Payment.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Payment {
    // static int num;
    // private int aud;
    // private int price;
    // private DataBase database;
    // private Seats seats;
    // private Ticket ticket;
    // private MoviesController cont;
    // private Email email;
    private Card card;
    // private Location location;
    
    public Payment() {

    }

    public Payment(Card card)
    {
        this.card = card;
        // seats = new Seats(database);
        // ticket = new Ticket(num, price, aud, seats, cont.getMovie(), cont.getLocation());
        
        // num++;
    }

    // public void makeReciept()
    // {
    //     //Make text of reciept?
    // }

    // public Seats getSeats()
    // {
    //     return seats;
    // }

    // public Ticket getTicket()
    // {
    //     return ticket;
    // }

    // public Email getEmail()
    // {
    //     return email;
    // }

    // public LocalDate getDate()
    // {
    //     return cont.getDate();
    // }

    // public String getMovie()
    // {
    //     return cont.getMovie().getTitle();
    // }

    // public Location getLocation()
    // {
    //     return location.getLocation();
    // }

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

    // public boolean refundPayment() {
    //     //refund payment

    //     // if ()   //If refund successfull return True 
    //     //     return true;
    //     // else 
    //     //     return false;

    //     return true;
    // }
    
}
