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
    private Seats seats;
    private Ticket ticket;
    private MoviesController cont;
    private Email email;
    private Card card;
    

    public Payment(MoviesController movCont, Card card)
    {
        cont = movCont;
        this.card = card 
        seat = new Seat()
        ticket = new Ticket(num, int aud, seats, cont.getMovie(), cont.getShow(), cont.getLocation)
        
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
        return cont.getDate().getDate();
    }

    public String getMovie()
    {
        return cont.getMovie().getTitle();
    }

    public getShowing()
    {
        return cont.getShowing().getShowing();
    }

    public getLocation()
    {

    }

    public boolean refundPayment()
    {
        //refund payment

        if ()   //If refund successfull return True 
            return true;
        else 
            return false;
    }
    
}
