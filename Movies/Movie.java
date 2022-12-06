/*
* Movie.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

package Movies;
import User.*;
import GUI.*;

//Saves the current movie title that the user has selected in this class
//Used for the purpose of saving the movie to show then on the reciept  
public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public Movie getMovie() {
        return this;
    }

    public String getTitle()
    {
        return title;
    }

}

