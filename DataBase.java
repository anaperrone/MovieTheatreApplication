/*
* DataBase.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/



import java.sql.*;
import java.util.*;
import java.time.*;


public class DataBase {
    private Connection connect;

    public DataBase(){
        initializeConnection();
    }

    /*
	* This method initializes the driver connection to the database using 
	* the username 'ensf' and password '480'.
	*/
    private void initializeConnection(){
        try{
            this.connect = DriverManager.getConnection("jdbc:mysql://localhost/MovieDatabase", "ensf", "480");
        }
        catch(SQLException e){
            System.out.println("ERROR: Could not connect to database");
        }
    }

    //method to check if the username exists in the database
    public boolean validateUsername(String username, String password){
        try{
            //select statement to retrieve all the usernames from the LOGIN table
            Statement s = this.connect.createStatement();
            String query = "SELECT username FROM LOGIN;";
            ResultSet results = s.executeQuery(query);

            //loop through each of the results retrieved from the table
            while(results.next()){
                String user = results.getString("username");
                //check to see if the username found in the table matches the new requested one
                if(user.compareTo(username) == 0){
                    results.close();
                    return false; //username exists, need to choose another
                }
            }
            
            //if the username requested does not already exist in the table, add it in along with the password
            String addQuery = "INSERT INTO LOGIN(username, pass) VALUES(?, ?);";
            PreparedStatement state = this.connect.prepareStatement(addQuery);
            state.setString(1, username);
            state.setString(2, password);
            state.execute();
            results.close();
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //method to check if the username and password exist in the database
    //if so, the user will be able to login
    public boolean grantAccess(String username, String password){
        try{
            Statement s = this.connect.createStatement();
            String query = "SELECT * FROM LOGIN;";
            ResultSet results = s.executeQuery(query);

            //loop through each result retrieved
            while(results.next()){
                String user = results.getString("username");
                String pass = results.getString("pass");
                //compare the username and password request to what is in the table
                //if they match, return true, meaning they can successfuly log in 
                if(user.compareTo(username) == 0 && pass.compareTo(password) == 0){
                    results.close();
                    return true;
                }
            }

            //no match found, cannot log in with the given username and password
            results.close();
            return false;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    /*
     * public method to remove a user from the database
     * the username will be removed from both the LOGIN table and the REGISTERED_USER table
     */
    public boolean removeUser(String username){
        try{
            String query = "DELETE FROM LOGIN WHERE username = ?;";
            PreparedStatement state = this.connect.prepareStatement(query);
            state.setString(1, username);
            state.execute();

            String get = "SELECT buildNum, streetName FROM REGISTERED_USER WHERE email = ?";
            PreparedStatment getState = this.connect.prepareStatement(query);
            getState.setString(1, username);
            ResultSet results = getState.executeQuery(get);
            int buildNum = results.getInt("buildNum");
            String streetName = results.getString("streetName");

            String removeCard = "DELETE FROM REGISTERED_USER WHERE email = ?;";
            PreparedStatement statement = this.connect.prepareStatement(remove);
            statement.setString(1, username);
            statement.execute();


            String remove = "DELETE FROM REGISTERED_USER WHERE email = ?;";
            PreparedStatement statement = this.connect.prepareStatement(remove);
            statement.setString(1, username);
            statement.execute();

            //String address = "DELETE FROM ADDRESS WHERE num = '" + 


            return true;
        }
    
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public void addRegisteredUser(String username, String password, int number, String streetname)
    {
        try
        {
            LocalDate today = LocalDate.now();
            java.sql.Date td = java.sql.Date.valueOf(today);
            String addQuery = "INSERT INTO REGISTERED_USER VALUES(?, ?, ?, ?, ?);";
            PreparedStatement state = this.connect.prepareStatement(addQuery);
            state.setString(1, username);
            state.setString(2, password);
            state.setInt(3, number);
            state.setString(4, streetname);
            state.setDate(5, td);
            state.execute();
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void addCard(String username, LocalDate expiry, String cardNumber, int cvv, String name)
    {
        try
        {
            java.sql.Date exp = java.sql.Date.valueOf(expiry);
            String addQuery = "INSERT INTO CARD VALUES(?, ?, ?, ?, ?);";
            PreparedStatement state = this.connect.prepareStatement(addQuery);
            state.setString(1, username);
            state.setDate(2, exp);
            state.setString(3, cardNumber);
            state.setInt(4, cvv);
            state.setString(5, name);
            state.execute();
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void addAddress(String street, int num, String city, String country, String postalCode)
    {
        try
        {
            String addQuery = "INSERT INTO ADDRESS VALUES(?, ?, ?, ?, ?);";
            PreparedStatement state = this.connect.prepareStatement(addQuery);
            state.setInt(1, num);
            state.setString(2, street);
            state.setString(3, city);
            state.setString(4, country);
            state.setString(5, postalCode);
            state.execute();
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void bookSeat(int seatNumber, String movie, String theatre, LocalDate date, Time time){
        try{
            Statement s = this.connect.createStatement();
            String query = "SELECT roomNum FROM SHOWING WHERE title = ? AND loc = ? AND date = ? AND time = ?;";
            ResultSet results = s.executeQuery(query);
            int room = results.getInt("roomNum");
            java.sql.Date newDate = java.sql.Date.valueOf(date);
            String addQuery = "INSERT INTO SEATS(theatreName, roomNum, d, t, seatNum) VALUES(?, ?, ?, ?, ?);";
            PreparedStatement state = this.connect.prepareStatement(addQuery);
            state.setString(1, theatre);
            state.setInt(2, room);
            state.setDate(3, newDate);
            state.setTime(4, time);
            state.setInt(5, seatNumber);
            state.execute();
            results.close();
            return;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    /*
     * public method to retrieve the times for a specific movie at a certain theatre on a certain date
     * returns an arraylist of times in which the movie is playing
     */
    public ArrayList<LocalTime> getMovTimes(String title, String theatreName, LocalDate date)
    {
        try{
            java.sql.Date newDate = java.sql.Date.valueOf(date);

            Statement s = this.connect.createStatement();
            String query = "SELECT movTime FROM SHOWING WHERE loc = '" + theatreName + "' AND movDate = '" + newDate + "' AND title = '" + title + "';";
            ResultSet results = s.executeQuery(query);

            //loop through all of the results and get the showtimes, add them to an arraylist of times
            ArrayList<LocalTime> showtimes = new ArrayList<LocalTime>();
            while(results.next())
            {
                LocalTime time = results.getObject("movTime", LocalTime.class);
                showtimes.add(time);

            } 

            results.close();
            return showtimes;
                
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /*
     * public method to get all the movies playing on a certain date
     * returns an arraylist of all the movie titles
     */
    public ArrayList<String> getMovies(LocalDate date)
    {
        try{
            String query = "SELECT title FROM SHOWING WHERE movDate = ? ";
            PreparedStatement state = this.connect.prepareStatement(query);
            java.sql.Date newDate = java.sql.Date.valueOf(date);
            state.setDate(1, newDate);
            ResultSet results = state.executeQuery(query);

            //loop through all the results and retrieve the titles of the movies 
            ArrayList<String> titles = new ArrayList<String>();
                while(results.next())
                {
                    String title = results.getString("title");
                    titles.add(title);

                } 

            results.close();
            return titles;
                
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    

    /*
     * public metho to retrieve the threatre name for all theatres in the database
     */
    public ArrayList<String> getLocations(){
        try{
            String query = "SELECT theatreName FROM SHOWING";
            PreparedStatement state = this.connect.prepareStatement(query);
            ResultSet results = state.executeQuery(query);

            //loop through all the results and get the names of all the theatres
            ArrayList<String> locations = new ArrayList<String>();
                while(results.next())
                {
                    String loc = results.getString("theatreName");
                    locations.add(loc);

                } 

            results.close();
            return locations;
                
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /*
     * public method which returns the full address for a selected theatre
     */
    public String getTheatreAddress(String theatre){
        try{
            String query = "SELECT * FROM SHOWING WHERE theatreName = ?";
            PreparedStatement state = this.connect.prepareStatement(query);
            state.setString(1, theatre);
            ResultSet results = state.executeQuery(query);

           
            String loc = results.getString("theatreName");
            int num = results.getInt("buildNum");
            String street = results.getString("streetName");
            String query2 = "SELECT * FROM ADDRESS WHERE num = '" + num + "' AND streetName = '" + street + "';";
            String fullAddress = loc + num + street ;

            results.close();
            return fullAddress;
                
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Integer> getSeats(String movie, String theatre, LocalDate date, LocalTime time){
        try{
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);
            java.sql.Time sqlTime = java.sql.Time.valueOf(time);
            
            Statement s = this.connect.createStatement();
            String query = "SELECT roomNum FROM SHOWING WHERE loc = '" + theatre + "' AND movDate = '" + sqlDate + "' AND movTime = '" + sqlTime + "' AND title = '" + movie + "';";
            // System.out.println(query);
            ResultSet results = s.executeQuery(query);
            
            ArrayList<Integer> roomNum = new ArrayList<Integer>();
            int room = 0; 
            while(results.next())
            {
                room = results.getInt("roomNum");
                roomNum.add(room);

            } 

            // System.out.println(room);
            
            query = "SELECT seatNum FROM SEATS WHERE roomNum = " + room + " AND theaterName = '"+ theatre + "' AND d = '" + sqlDate + "' AND t = '" + sqlTime + "';";
            // System.out.println(query);
            // state = this.connect.prepareStatement(query);
            // state.setInt(1, room);
            // state.setString(2, theatre);
            // state.setDate(3, sqlDate);
            // state.setTime(4, sqlTime);
            results = s.executeQuery(query);

            ArrayList<Integer> seats = new ArrayList<Integer>();
            while(results.next())
            {
                int seat = results.getInt("seatNum");
                seats.add(seat);

            } 

            results.close();
            return seats;
                
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }



    //close database connection
    public void close(){
        try{
            this.connect.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}




