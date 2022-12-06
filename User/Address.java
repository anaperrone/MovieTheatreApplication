/*
* Address.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

/*
 * public class Address which works with database table ADDRESS.
 */

package User;
import Movies.*;
import GUI.*;

public class Address {
    private String streetName;
    private int number;
    private String city;
    private String country;
    private String postalCode;

    /*
     * Public constructor to create new object of address. It takes in street name, building number, city,
     * country and the postal code. Returns nothing. 
    */
    public Address(String name, int num, String city, String country, String postal) {
        this.streetName = name; 
        this.number = num;
        this.city = city;
        this.country = country;
        this.postalCode = postal;
    }

    /*
     * Public getter that returns address object.
    */
    public Address getAddress() {
        return this;
    }

    /*
     * public setter to change address. Takes in street name, building number, city, country, and postal code
    */

    public void setAddress(String name, int num, String city, String country, String postal) {
        this.streetName = name;
        this.number = num;
        this.city = city;
        this.country = country;
        this.postalCode = postal;
    }
    
}
