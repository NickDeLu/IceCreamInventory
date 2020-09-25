/*
    IceCream.java
    Author: Nick De Luca
    Date: August 7th 2020
    Description
    This class defines the properties and attributes of the IceCream object.
*/
package model;

/**
 * This class defines an icecream's properties and attributes in an inventory
 * @author Nick De Luca
 */
public class IceCream {

    private IceCreamFlavour flavour;
    private double price;
    private int quantity;
    
    /**
     * Constructs an empty IceCream object
     */
    public IceCream() {
    }
     /**
     * Constructs an IceCream of a specific flavour, price, and quantity.
     * @param flavour the flavour of icecream given
     * @param price the price of the flavour
     * @param quantity how many of a given flavour
     */
    public IceCream(IceCreamFlavour flavour, double price, int quantity) {
        this.flavour = flavour;
        this.price = price;
        this.quantity = quantity;
    }
    /**
     * gets the flavour of icecream in the inventory.
     * @return the flavour of icecream
     */ 
    public IceCreamFlavour getFlavour() {
        return flavour;
    }
    /**
     * gets the quantity of icecream in the inventory.
     * @return the quantity of icecream
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * gets the cost of icecream in the inventory.
     * @return the cost of icecream
     */
    public double getCost(){
       return (quantity*price);
    }
    /**
     * The toString method that lists an id, flavour, price, quantity, cost 
     * of an icecream in the inventory as a formatted string.
     * @return the formatted string of the icecream in the inventory
     */
    @Override
    public String toString() {
        return String.format("%-3d%-15s%-8.2f%-5d%-7.2f"
                ,flavour.getId(),flavour.getFlavour(),price,quantity,quantity*price);
    } 
}
