/*
* Card.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

public class Card {
    private MyDate expiry;
    private String cardNumber; //int? can it hold 16 digits?
    private int cvv;
    private String name;

    public Card(MyDate e, String n, int c, String name) {
        this.expiry = e;
        this.cardNumber = n;
        this.cvv = c;
        this.name = name;
    }

    public void verifyCard(int c) {

    }

    public boolean doPayment() {
        return true;
    }

    public String getCardNumber(){
        return cardNumber;
    }
}
