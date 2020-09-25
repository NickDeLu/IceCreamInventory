/*
    IceCreamFlavour.java
    Author: Nick De Luca
    Date: August 7th 2020
    Description
    This Enummeration class defines enums for the 
    Icecream flavours within an ice cream inventory
*/
package model;

/**
 * This enumeration defines IceCreamFlavours 
 * @author nicol
 */
public enum IceCreamFlavour {
    
    VANILLA (1,"Vanilla", 2.39), 
    CHOCOLATE (2,"Chocolate", 2.69), 
    MANGO (3,"Mango", 2.99),
    STRAWBERRY (4,"Strawberry", 2.79),
    BUTTER_PECAN (5,"Butter Pecan", 2.59), 
    MOOSE (6,"Moose", 2.49),
    RASPBERRY (7,"Raspberry", 2.89);
   
    private int id;
    private String flavourName;
    private double price;
    /**
     * This constructor instantiates a IceCreamFlavour enumeration object with a given
     * id, flavour, and price. 
     * @param id the given id to set
     * @param flavour the given flavour to set
     * @param price the given price to set
     */
    private IceCreamFlavour(int id, String flavour, double price){
        this.id = id;
        this.flavourName = flavour;
        this.price = price;
    }
    /**
     * gets the id of the IceCreamFlavour enumeration object
     * @return the id of this enumeration object
     */
    public int getId() {
        return id;
    }
     /**
     * gets the flavour of the IceCreamFlavour enumeration object
     * @return the flavour of this enumeration object
     */
    public String getFlavour() {
        return flavourName;
    }
    /**
     * gets the price of the IceCreamFlavour enumeration object
     * @return the price of this enumeration object.
     */
    public double getPrice() {
        return price;
    }
    
}
