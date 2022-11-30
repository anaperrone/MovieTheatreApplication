/*
* Card.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

import java.util.regex.*;

public class Card {
    private MyDate expiry;
    private String cardNumber; //int? can it hold 16 digits?
    private int cvv;
    private String name;
    private String CARD_REGEX = "[0-9]{16}";
    private Pattern CARD_PATTERN = Pattern.compile(CARD_REGEX);

    public Card(MyDate e, String n, int c, String name) {
        this.expiry = e;
        this.cardNumber = n;
        this.cvv = c;
        this.name = name;
    }

    public void verifyCard(int cvv, String cardNumber) {
        if(cvv > 3 || cvv < 3) {
            //invalid card
        }
        Matcher cardMatcher = CARD_PATTERN.matcher(cardNumber);
        if(cardMatcher.find()) {
            //valid card number
        }
    }

    public boolean doPayment() {
        return true;
    }

    public String getCardNumber(){
        return cardNumber;
    }
}
