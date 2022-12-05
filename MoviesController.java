/*
* MoviesController.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

import java.time.*;
import java.util.ArrayList; 

//Movies controller contains both the individual selection the user makes such as the movie, location, date, and time AND
//retrieves all the options that are available in the database which the user can choose
public class MoviesController {
    private DataBase database;
    private ArrayList<String> movies; //Saves all the movie options we have in the database 
    private Movie movie;
    private ArrayList<LocalDate> dates; //Saves all the date options for the movie at that location in the database
    private LocalDate date;
    private ArrayList<String> locations; //Saves all the location options for the movie at that location in the database
    private Location location;
    private ArrayList<LocalTime> showTimes; //Saves all the showtime options for the movie at that location in the database
    private LocalTime showTime;
    private Seats seats;
    private ArrayList<Integer> ticketsNotAvailable; //Stores all the seats that are already booked so that the user cannot select those seats


    //Showing takes all 3 parameters and would ideally call the database to match them with a showing that matches the query
    public MoviesController(DataBase db) {
        database = db;
        movies = db.getMovies();
        locations = db.getLocations();
        seats = new Seats(db);
    }

    public void newShowTimes()
    {
        DataBase d = new DataBase();
        showTimes = d.getMovTimes(movie.getTitle(), location.getTheatreName(), date);
        //d.close();
    }

    public void setMovieLocation(String title, String location) {
        this.movie = new Movie(title);
        this.location = new Location(location);
        dates = database.getDates(title, location);
    }

    public void setMovie(String title) {
        movie = new Movie(title); //Entirely new query is asked for 
        newShowTimes();
    }

    public void setDate(LocalDate date) {
        this.date = date;
        newShowTimes();
    }

    public void setLocation(String loc) {
        location = new Location(loc);
        newShowTimes();
    }

    public void setShow(LocalTime showTime) {
        this.showTime = showTime;
    }


    public ArrayList<Integer> getTickets() {
        ticketsNotAvailable = seats.getAvailableSeats(movie.getTitle(), location.getTheatreName(), date, showTime);
        return ticketsNotAvailable;
    }

    // public void setShow(LocalTime showing) { //When a user selects a showing
    //     show = new Showing(showing);
    // }

    // public void setShow() { //When a user changes the movie, date, or location it has to be reflected in showing
    //     show = new Showing(movie, date, location);
    // }

    public Movie getMovie() {
        return this.movie; 
    }

    public LocalDate getDate() {
        return this.date;
    }

    public Location getLocation() {
        return this.location;
    }

    public LocalTime getShow() {
        return this.showTime;
    }

    // public Showing getShow() {
    //     return this.show;
    // }

    public ArrayList<LocalTime> getShowTimes()
    {
        return this.showTimes;
    }

    public ArrayList<String> getMovies() {
        return this.movies;
    }

    public ArrayList<String> getLocations() {
        return this.locations;
    }

    public ArrayList<LocalDate> getDateS() {
        return this.dates;
    }

}