/*
* Movie.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/
import java.time.*;   
public class Movie {
    private int duration; 
    private String title;
    private LocalDate releaseDate;

    public Movie(String title) {
        this.title = title;
        if(title.equals("AllMovies")) {
            //Do a different database call
        }
        else{
        //Call a database function that retrieves the other variables 
        }
    }

    public Movie getMovie() {
        return this;
    }

    public String getTitle()
    {
        return title;
    }

}

