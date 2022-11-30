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


public class Connection {
    private Connection connect;

    public Connection(){
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
    private boolean findUsername(String username){
        try{
            Statement s = this.connect.createStatement();
            String query = "SELECT username FROM LOGIN;";
            ResultSet results = s.executeQuery(query);

            while(results.next()){
                String user = results.getString("username");
                if(user == username){
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
    }

    //method to check if the username and password exist in the database
    //if so, the user will be able to login
    private boolean grantAccess(String username, String password){
        try{
            Statement s = this.connect.createStatement();
            String query = "SELECT * FROM LOGIN;";
            ResultSet results = s.executeQuery(query);

            while(results.next()){
                String user = results.getString("username");
                String pass = results.getString("pass");
                if(user == username && pass == password){
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
