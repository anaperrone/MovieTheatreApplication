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

    public ArrayList<Integer> getAvailableSeats(String title, String theatre, LocalDate date, LocalTime time){
        ArrayList<Integer> seats = database.getSeats(title, theatre, date, time);
        return seats;
    }

    public void bookSeat(int seat, String title, String theatre, LocalDate date, LocalTime time, String email){
        database.bookSeat(seat, title, theatre, date, time, email);
    }

    public String cancelSeat(int ticketNum, String email){
        return database.cancelSeat(ticketNum, email);
    }
}
