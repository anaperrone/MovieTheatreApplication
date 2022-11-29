import java.time.LocalTime;

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
public class MoviesController {
    private Movie movie;
    private MyDate date;
    private Location location;
    private Showing show;

    //If title string is set to "AllMovies" then movie will conduct something different
    //If loc string is set to "AllLocations" then location will conduct something different
    //Showing takes all 3 parameters and would ideally call the database to match them with a showing that matches the query
    public MoviesController(String title, LocalDate date, String loc) {
        movie = new Movie(title);
        this.date = new MyDate(date);
        location = new Location(loc);
        show = new Showing(movie, this.date, location);
    }

    public void setMovie(String title) {
        movie = new Movie(title); //Entirely new query is asked for 
        setShow();
    }

    public void setDate(LocalDate date) {
        this.date = new MyDate(date);
        setShow();
    }

    public void setLocation(String loc) {
        location = new Location(loc);
        setShow();
    }

    public void setShow(LocalTime showing) { //When a user selects a showing
        show = new Showing(showing);
    }

    public void setShow() { //When a user changes the movie, date, or location it has to be reflected in showing
        show = new Showing(movie, date, location);
    }

    public Movie getMovie() {
        return this.movie; 
    }

    public MyDate getDate() {
        return this.date;
    }

    public Location getLocation() {
        return this.location;
    }

    public Showing getShow() {
        return this.show;
    }

}