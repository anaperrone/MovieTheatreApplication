/*
* Connection.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

package package1;

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
    public boolean addUsername(String username, String password){
        try{
            Statement s = this.connect.createStatement();
            String query = "SELECT username FROM LOGIN;";
            ResultSet results = s.executeQuery(query);

            while(results.next()){
                String user = results.getString("username");
                if(user == username){
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

    private void removeUser(String username){
        try{
            Statement s = this.connect.createStatement();
            String query = "DELETE FROM LOGIN WHERE username = ?;";
            PreparedStatement state = this.connect.prepareStatement(query);
            state.setString(1, username);
            state.execute();
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

        // private void registerUser(String username, ){

        // }





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



