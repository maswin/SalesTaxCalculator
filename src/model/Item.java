package model;

/**
 * Created by alagapm on 12/16/15.
 */
public class Item {

    private String itemName;
    private double rate;

    public Item(String itemName, double rate){
        this.setItemName(itemName);
        this.setRate(rate);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
