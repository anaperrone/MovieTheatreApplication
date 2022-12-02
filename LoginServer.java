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

    private LoginServer(){
        usernameList = new ArrayList<String>();
        passwordList = new ArrayList<String>();
    }

    public static LoginServer getOnlyInstance(){
        if(onlyInstance == null)
            onlyInstance = new LoginServer();

        return onlyInstance;
    }

    public void setOnlyInstance(LoginServer only){
        onlyInstance = only;
    }

    public boolean add(String username, String password){
        if(!usernameList.contains(username)){
            usernameList.add(username);
            passwordList.add(password);
            return true;
        }
        else{
            return false;
            //connect to the gui here, maybe prompt to select another username
        }
    }

    public void setUsername(int index, String newUsername){
        usernameList.set(index, newUsername);
    }

    public void removeUsername(int index){
        usernameList.remove(index);
        
    }

}
