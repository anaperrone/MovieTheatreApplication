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
    private Date expiry;
    private int num;
    private int cv;
    private String name;

    public Card(Date e, int n, int c, String name) {
        this.expiry = e;
        this.num = n;
        this.cv = c;
        this.name = name;
    }

    public void verifyCard(int c) {

    }

    public boolean doPayment() {
        return true;
    }
}
