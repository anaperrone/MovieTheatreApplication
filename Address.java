/*
* Address.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

public class Address {
    private String streetName;
    private int number;
    private String city;
    private String country;
    private String postalCode;

    public Address(String name, int num, String city, String country, String postal) {
        this.streetName = name; 
        this.number = num;
        this.city = city;
        this.country = country;
        this.postalCode = postal;
    }

    public Address getAddress() {
        //Address address = new Address(streetName, number, city, country, postalCode);
        return this;
    }

    public void setAddress(String name, int num, String city, String country, String postal) {
        this.streetName = name;
        this.number = num;
        this.city = city;
        this.country = country;
        this.postalCode = postal;
    }
    
}
