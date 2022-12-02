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

    private LoginServer(){
        usernameList = new ArrayList<String>();
        passwordList = new ArrayList<String>();
        database = new DataBase();
    }

    public static LoginServer getOnlyInstance(){
        if(onlyInstance == null)
            onlyInstance = new LoginServer();

        return onlyInstance;
    }

    public void setOnlyInstance(LoginServer only){
        onlyInstance = only;
    }

    public boolean checkUsername(String username, String password){
        boolean available =  database.validateUsername(username, password);
        if(available){
            usernameList.add(username);
            passwordList.add(password);
        }
        return available;
    }


    public void removeUsername(String username){
        //remove the username from the local list
        usernameList.remove(username);

        //call the databse remove method for Login table and Registered User
        database.removeUser(username);

    }

}
