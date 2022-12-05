/*
* Seats.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

import java.util.*;
import java.time.*;

public class Seats {
    private DataBase database;

    public Seats(DataBase database){
        this.database = database;
    }

    //Gets all seats that are currently booked for the movie and show time at that date and sends an arraylist to movies controller
    public ArrayList<Integer> getAvailableSeats(String title, String theatre, LocalDate date, LocalTime time){
        ArrayList<Integer> seats = database.getSeats(title, theatre, date, time);
        return seats;
    }

    //SENDS information to the database regarding booking details
    public void bookSeat(int seat, String title, String theatre, LocalDate date, LocalTime time, String email){
        database.bookSeat(seat, title, theatre, date, time, email);
    }

    //Cancels a seat when given an email and ticket number
    public String cancelSeat(int ticketNum, String email){
        return database.cancelSeat(ticketNum, email);
    }
}
