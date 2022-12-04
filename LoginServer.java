/*
* LoginServer.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/
import java.util.ArrayList;

public class LoginServer {
    private static LoginServer onlyInstance;
    private ArrayList<String> usernameList;
    private ArrayList<String> passwordList;
    private DataBase database;

    /*
     * private constructor for login server (Singleton pattern) which creates
     * empty arraylists for the username and password as well as create a new
     * database connection
     */
    
    private LoginServer(){
        usernameList = new ArrayList<String>();
        passwordList = new ArrayList<String>();
    }

    /*
     * public getter for local instance of LoginServer (Singleton)
     * returns the a LoginServer object
     */
    public static LoginServer getOnlyInstance(){
        if(onlyInstance == null)
            onlyInstance = new LoginServer();

        return onlyInstance;
    }

    public void setDatabase(DataBase data){
        this.database = data;
    }

    /*
     * public setter to set the instance of LoginServer object
     */
    public void setOnlyInstance(LoginServer only){
        onlyInstance = only;
    }

    /*
     * public method to check the username and password by calling the method in
     * the database class and retrieving a boolean which will be returned to the method
     * which called this one. Will return true if the username is available and can be 
     * put into the database as a new username
     */
    public boolean checkUsername(String username, String password){
        boolean available =  database.validateUsername(username, password);
        if(available){
            usernameList.add(username);
            passwordList.add(password);
        }
        return available;
    }

    /*
     * public method to remove a username from the database
     * and local
     */
    public void removeUsername(String username){
        //find the index where the username exists
        int index = usernameList.indexOf(username);
        //remove the username and password at that index
        usernameList.remove(index);
        passwordList.remove(index);

        //call the databse remove method for Login table and Registered User
        database.removeUser(username);

    }

}
