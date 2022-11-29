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
    private Seats seats;
    private Ticket ticket;
    private MovieController cont;
    private Email email;
    

    public Payment()
    {

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
