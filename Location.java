/*
* Location.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

//Stores the specific theatre location that the user has selected
public class Location {
    private String theatreName;
    //private Address address;

    public Location(String loc) {
        theatreName = loc;
        //Database does query to return address of the location and sets the address depending on that
    }

    public Location getLocation() {
        return this;
    }

    public String getTheatreName()
    {
        return theatreName;
    }
}
