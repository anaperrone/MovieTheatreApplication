/*
* OrdinaryUser.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

package User;
import Movies.*;
import GUI.*;

import java.util.*;
import java.time.*;

public class OrdinaryUser { 
    private String email;
    private LocalDate purchaseDate;
    private DataBase database;


    //defualt constructor
    public OrdinaryUser(DataBase database){
        this.database = database;
    }

    //method to be called once a guest checks out to purchase a ticket
    public void addOrdinaryUser(String e){
        this.email = e;

        database.addOrdinaryUser(e, LocalDate.now());
        
    }
}
