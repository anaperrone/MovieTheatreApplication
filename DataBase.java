/*
* Connection.java
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
            Statement s = this.connect.createStatement();
            String query = "SELECT username FROM LOGIN;";
            ResultSet results = s.executeQuery(query);

            while(results.next()){
                String user = results.getString("username");
                if(user.compareTo(username) == 0){
                    results.close();
                    return false; //username exists, need to choose another
                }
            }
            
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

            while(results.next()){
                String user = results.getString("username");
                String pass = results.getString("pass");
                if(user.compareTo(username) == 0 && pass.compareTo(password) == 0){
                    results.close();
                    return true;
                }
            }

            results.close();
            return false;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public void removeUser(String username){
        try{
            Statement s = this.connect.createStatement();
            String query = "DELETE FROM LOGIN WHERE username = ?;";
            PreparedStatement state = this.connect.prepareStatement(query);
            state.setString(1, username);
            state.execute();

            Statement st = this.connect.createStatement();
            String remove = "DELETE FROM REGISTERED_USER WHERE username = ?";
            PreparedStatement statement = this.connect.prepareStatement(remove);
            statement.setString(1, username);
            statement.execute();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void bookSeat(int seatNumber, String movie, String theatre, String date, Time time){
        try{
            Statement s = this.connect.createStatement();
            String query = "SELECT roomNum FROM SHOWING WHERE title = ? AND loc = ? AND date = ? AND time = ?;";
            ResultSet results = s.executeQuery(query);
            int room = results.getInt("roomNum");
            
            String addQuery = "INSERT INTO SEATS(theatreName, roomNum, d, t, seatNum) VALUES(?, ?, ?, ?, ?);";
            PreparedStatement state = this.connect.prepareStatement(addQuery);
            state.setString(1, theatre);
            state.setInt(2, room);
            state.setString(3, date);
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

    private Time[] getMovTimes(string title, String theatreName, Date date)
    {
        try{
            Statement s = this.connect.createStatement();
            String query = "SELECT movTime FROM SHOWING WHERE loc = " + theatreName + " AND movDate = " + date + " AND title" = title;
            ResultSet results = s.executeQuery(query);
            ArrayList<LocalTime> showtime;
                while(results.next())
                {
                    Time time = results.getTime("movTime");

                } 

            results.close();
            return true;
                
            }

            results.close();
            return results;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
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



