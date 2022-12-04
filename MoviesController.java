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

public class MoviesController {
    private ArrayList<String> movies;
    private Movie movie;
    private LocalDate date;
    private ArrayList<String> locations;
    private Location location;
    private ArrayList<LocalTime> showTimes;

    //If title string is set to "AllMovies" then movie will conduct something different
    //If loc string is set to "AllLocations" then location will conduct something different
    //Showing takes all 3 parameters and would ideally call the database to match them with a showing that matches the query
    public MoviesController(DataBase db) {
        movies = db.getMovies();
        locations = db.getLocations();

    }
    
    public MoviesController(String title, LocalDate date, String loc) {
        movie = new Movie(title);
        this.date = date;
        location = new Location(loc);
        newShowTimes();
    }

    public void newShowTimes()
    {
        DataBase d = new DataBase();
        showTimes = d.getMovTimes(movie.getTitle(), location.getTheatreName(), date);
        d.close();
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

}