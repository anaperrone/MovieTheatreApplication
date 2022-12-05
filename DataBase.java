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
    //connection object which stores the connection to the database
    private Connection connect;

    //constructor for database which calls the method to iniialize the connection
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
    public void removeUser(String username){
        try{
            //delete the username from the LOGIN table
            String query = "DELETE FROM LOGIN WHERE username = ?;";
            PreparedStatement state = this.connect.prepareStatement(query);
            state.setString(1, username);
            state.execute();

            //retrieve the address associated with this profile
            String get = "SELECT buildNum, streetName FROM REGISTERED_USER WHERE email = ?";
            PreparedStatement getState = this.connect.prepareStatement(query);
            getState.setString(1, username);
            ResultSet results = getState.executeQuery(get);
            int buildNum = results.getInt("buildNum");
            String streetName = results.getString("streetName");

            //finally delete the the user from the REGISTERED_USER table
            String removeUser = "DELETE FROM REGISTERED_USER WHERE email = ?;";
            PreparedStatement deleteUser = this.connect.prepareStatement(removeUser);
            deleteUser.setString(1, username);
            deleteUser.execute();

            //then delete the card information attached to the profile
            String removeCard = "DELETE FROM CARD WHERE email = ?;";
            PreparedStatement statement = this.connect.prepareStatement(removeCard);
            statement.setString(1, username);
            statement.execute();

            //then delete the address associated with this profile
            String removeAddress = "DELETE FROM ADDRESS WHERE num = '" + buildNum + "' AND streetName = '" + streetName + "';";
            PreparedStatement st = this.connect.prepareStatement(removeAddress);
            st.execute();

        }
    
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public LocalDate getRegistrationDate(String username)
    {
        try
        {
            Statement s = this.connect.createStatement();
            String addQuery = "SELECT signupdate FROM REGISTERED_USER WHERE email = '" + username + "';";
            ResultSet results = s.executeQuery(addQuery);
        
            LocalDate signUp = LocalDate.now();
            while (results.next())
            {
                signUp = results.getObject("signupdate", LocalDate.class);
            }

            return signUp;
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return null;

    }

    public void addRegisteredUser(String username, String password, int number, String streetname, String cardNumber, int cvv)
    {
        try
        {
            LocalDate today = LocalDate.now();
            java.sql.Date td = java.sql.Date.valueOf(today);
            String addQuery = "INSERT INTO REGISTERED_USER VALUES(?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement state = this.connect.prepareStatement(addQuery);
            state.setString(1, username);
            state.setString(2, password);
            state.setInt(3, number);
            state.setString(4, streetname);
            state.setDate(5, td);
            state.setString(6, cardNumber);
            state.setInt(7, cvv);
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

    public boolean checkCard(int cvv, String cardNumber)
    {
        try
        {
            Statement s = this.connect.createStatement();
            String cardQuery = "SELECT cv, num FROM CARD;";
            ResultSet results = s.executeQuery(cardQuery);

            //loop through each result retrieved
            while(results.next()){
                String num = results.getString("num");
                int cv = results.getInt("cv");
                //compare the card number and cvv to existing ones in the database
                if(cardNumber.compareTo(num) == 0 && cv == cvv){
                    results.close();
                    return false;
                }
            }

            //no card with this match was found, can add it to the database
            return true;
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validateAddress(String street, int number)
    {
        try
        {
            Statement s = this.connect.createStatement();
            String cardQuery = "SELECT streetName, num FROM ADDRESS;";
            ResultSet results = s.executeQuery(cardQuery);

            //loop through each result retrieved
            while(results.next()){
                int num = results.getInt("num");
                String name = results.getString("streetName");
                System.out.println(name);
                System.out.println(num);
                //compare the street number and name to existing ones in the database
                if(street.equalsIgnoreCase(name) && num == number){
                    results.close();
                    return false;
                }
            }

            //no card with this match was found, can add it to the database
            return true;
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
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

    public String bookSeat(int seatNumber, String movie, String theatre, LocalDate date, LocalTime time, String email){
        try{
            //convert LocalDate and Time to the sql equivalent
            java.sql.Date newDate = java.sql.Date.valueOf(date);
            java.sql.Time sqlTime = java.sql.Time.valueOf(time);
            
            Statement s = this.connect.createStatement();
            String query = "SELECT roomNum FROM SHOWING WHERE title = '" + movie + "' AND loc = '" + theatre + "' AND date = '" + newDate + "' AND time = '" + sqlTime + "';";
            ResultSet results = s.executeQuery(query);
            int room = results.getInt("roomNum");

            String addQuery = "INSERT INTO SEATS(theaterName, roomNum, d, t, seatNum, email) VALUES(?, ?, ?, ?, ?, ?);";
            PreparedStatement state = this.connect.prepareStatement(addQuery);
            state.setString(1, theatre);
            state.setInt(2, room);
            state.setDate(3, newDate);
            state.setTime(4, sqlTime);
            state.setInt(5, seatNumber);
            state.setString(6, email);
            state.execute();
            results.close();
            String message = "Successfully booked seat and ticket for: \nMovie: " + movie + "\nDate: " + date + "\nTime: " + time + "\nTheater: " + theatre + "\nSeat: " + seatNumber;
            Email em = new Email();
            em.sendEmail(email, message, "Cinemama - Confirmation of Ticket Booking");
            return message;
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    /*
     * public method to cancel a booking for a seat. 
     * selects the details of the booking and checks if the booking exists will
     * return the appropriate string depending on if the ticket can be cancelled or 
     */
    public String cancelSeat(int ticketNum, String email){
        try{
            Statement s = this.connect.createStatement();
            //select the details of the booking with the provided ticketnumber and email
            String query = "SELECT roomNum, theaterName, d, t FROM SEATS WHERE ticketNum = '" + ticketNum + "' AND email = '"+ email +"';";
            ResultSet results = s.executeQuery(query);
            //else, there is a booking and we store the details in local variables
            int room = 0;
            String theatre = "";
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now(); 
            while(results.next())
            {
                room = results.getInt("roomNum");
                theatre = results.getString("theaterName");
                date = results.getObject("d", LocalDate.class);
                time = results.getObject("t", LocalTime.class);
            } 
            
            //if the results came bul empty (null) then there is no booking under this email for this ticket number
            if(room == 0 && theatre.compareTo("") == 0)
            {
                return "ERROR: Could not find booking with ticketNum " + ticketNum + " and email " + email +" ";
            }
            
            //select the title of the movie based on these details from SHOWING table
            String getTitle= "SELECT title FROM SHOWING WHERE roomNum = '" + room + "' AND loc = '" + theatre + "' AND movDate = '"
                                + date + "' AND movTime = '" + time + "';";
            ResultSet res = s.executeQuery(getTitle);
            
            String title = "";
            while(res.next())
            {
                title = res.getString("title");
            } 

            //delete the ticket, making the seat available now
            String deleteQuery = "DELETE FROM SEATS WHERE ticketNum = '" + ticketNum + "' AND email = '" + email + "'";
            PreparedStatement state = this.connect.prepareStatement(deleteQuery);
            state.execute();
            results.close();
            //return ticket cancellation details
            String message = "Ticket for " + title + " on " + date + " at " + time + " showing at " + theatre + " successfully cancelled. ";
            Email em = new Email();
            em.sendEmail(email, message, "Cinemama - Ticket Cancellation Cofirmation");
            return message;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return "ERROR: Could not cancel ticket. Please Try again.";
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
            //select the showtimes based on the given details
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
     * public method which gets all the dates which a movie is playing at a location
     */
    public ArrayList<LocalDate> getDates(String title, String theatre){
        try{
            Statement s = this.connect.createStatement();
            //select the showtimes based on the given details
            String query = "SELECT movDate FROM SHOWING WHERE loc = '" + theatre + "' AND title = '" + title + "';";
            ResultSet results = s.executeQuery(query);

            //loop through all of the results and get the showtimes, add them to an arraylist of times
            ArrayList<LocalDate> showdates = new ArrayList<LocalDate>();
            while(results.next())
            {
                LocalDate date = results.getObject("movDate", LocalDate.class);
                showdates.add(date);

            } 

            results.close();
            return showdates;
                
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
    public ArrayList<String> getMovies()
    {
        try{
            String query = "SELECT DISTINCT title FROM SHOWING;";
            PreparedStatement state = this.connect.prepareStatement(query);
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
     * public method to retrieve the threatre name for all theatres in the database
     */
    public ArrayList<String> getLocations(){
        try{
            String query = "SELECT DISTINCT loc FROM SHOWING";
            PreparedStatement state = this.connect.prepareStatement(query);
            ResultSet results = state.executeQuery(query);

            //loop through all the results and get the names of all the theatres
            ArrayList<String> locations = new ArrayList<String>();
                while(results.next())
                {
                    String loc = results.getString("loc");
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
            String query = "SELECT * FROM SHOWING WHERE theaterName = ?";
            PreparedStatement state = this.connect.prepareStatement(query);
            state.setString(1, theatre);
            ResultSet results = state.executeQuery(query);

           
            String loc = results.getString("theaterName");
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

    /*
     * public method which gets the available seats from the database for the specific date, time, location and movie
     */
    public ArrayList<Integer> getSeats(String movie, String theatre, LocalDate date, LocalTime time){
        try{
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);
            java.sql.Time sqlTime = java.sql.Time.valueOf(time);
            
            Statement s = this.connect.createStatement();
            String query = "SELECT roomNum FROM SHOWING WHERE loc = '" + theatre + "' AND movDate = '" + sqlDate + "' AND movTime = '" + sqlTime + "' AND title = '" + movie + "';";
            ResultSet results = s.executeQuery(query);
            
            //get the roomnumber where this movie is showing at the date, time and theatre selected 
            ArrayList<Integer> roomNum = new ArrayList<Integer>();
            int room = 0; 
            while(results.next())
            {
                room = results.getInt("roomNum");
                roomNum.add(room);
            } 
            
            query = "SELECT seatNum FROM SEATS WHERE roomNum = " + room + " AND theaterName = '"+ theatre + "' AND d = '" + sqlDate + "' AND t = '" + sqlTime + "';";
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




