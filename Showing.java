/*
* Showing.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/
import java.time.*;
import java.util.*;
public class Showing {
    private ArrayList<LocalTime> showTimes;

    public Showing(Movie movie, Date date, Location loc) {
        //Query where movie.title, date, and location is sent 
        //It would return an array list of show times that showTimes is then set to and sent back to display
        String title = movie.getTitle();
        String theatreName = loc.getTheatreName();
        DataBase d = new Database();
        showTimes = d.getMovTimes(title, theatreName, date);
    }

    public ArrayList<LocalTime> getShowTimes()
    {
        return showTimes;
    }

    public Showing(LocalTime time) {
        showTimes.clear();
        showTimes.add(time); //When ticket is being purchased 
    }
    public Showing getShowing() {
        return this;
    }
}
