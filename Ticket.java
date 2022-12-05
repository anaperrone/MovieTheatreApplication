/*
* Ticket.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

public class Ticket {
    private int ticketNum;
    private int auditorium;
    private Seats seat;
    private Movie movie;
    private Location location;
    private int price = 8;

    public Ticket(int ticket, int price, int aud, Seats seat, Movie mov, Location loc) {
        this.ticketNum = ticket;
        this.price = price;
        this.auditorium = aud;
        this.seat = seat;
        this.movie = mov;
        this.location = loc;
    }

    public Ticket getTicket() {
        return this;
    }

    public void setTicket(int ticket, int aud, Seats seat, Movie mov, Location loc) {
        this.ticketNum = ticket;
        this.auditorium = aud;
        this.seat = seat;
        this.movie = mov;
        this.location = loc;
    }
}
