package model;

/**
 * Created by alagapm on 12/16/15.
 */
public class ItemData {

    private Item item;
    private int quantity;
    private  boolean isImported;

    public ItemData(Item item, int quantity, boolean isImported){

        this.item = item;
        this.quantity = quantity;
        this.isImported = isImported;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }
}
