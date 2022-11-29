/*
* OrdinaryUser.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

public class OrdinaryUser {
    private String email;
    private Card card;


    public OrdinaryUser(){}

    public void addEmail(String e){
        email = e;
    }

    public void addCard(int cvv, String cardNumber, Date expiry, String name){
        Card c = new Card(expiry, cardNumber, cvv, name);
        card = c;
    }
}
