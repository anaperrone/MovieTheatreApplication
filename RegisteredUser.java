/*
* RegisteredUser.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/
import java.util.ArrayList;

public class RegisteredUser extends OrdinaryUser{
    private String username;
    private String password;
    private ArrayList<Card> cards;
    private String email;
    private Address address;
    private LoginServer instance;


    public RegisteredUser(String username, String password, String email, Date expiry, 
                            String name, int cvv, String cardNumber, String streetName, 
                            int no, String city, String country, String postal){

        username = username; 
        password = password;
        Card card = new Card(expiry, cardNumber, cvv, name);
        Address add = new Address(streetName, no, city, country, postal);
        address = add;
        cards.add(card);
    }

    public void remove(Card card){
        String num = card.getCardNumber();
        for(int i = 0; i< cards.size(); i++){
            if(cards.get(i).getCardNumber() == num){
                cards.remove(i);
            }
        }
    }

    public void addCard(Card card){
        cards.add(card);
    }
}
