import java.time.LocalDate;

/*
* Payment.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

public class Payment {
    static int num;
    private int aud;
    private DataBase database;
    private Seats seats;
    private Ticket ticket;
    private MoviesController cont;
    private Email email;
    private Card card;
    private Location location;
    

    public Payment(MoviesController movCont, Card card)
    {
        cont = movCont;
        this.card = card;
        seats = new Seats(database);
        ticket = new Ticket(num, aud, seats, cont.getMovie(), cont.getLocation());
        
        num++;
    }

    public void makeReciept()
    {
        //Make text of reciept?
    }

    public Seats getSeats()
    {
        return seats;
    }

    public Ticket getTicket()
    {
        return ticket;
    }

    public Email getEmail()
    {
        return email;
    }

    public LocalDate getDate()
    {
        return cont.getDate();
    }

    public String getMovie()
    {
        return cont.getMovie().getTitle();
    }

    public Location getLocation()
    {
        return location.getLocation();
    }

    public boolean refundPayment() {
        //refund payment

        // if ()   //If refund successfull return True 
        //     return true;
        // else 
        //     return false;

        return true;
    }
    
}
