package model;

/**
 * Created by alagapm on 12/16/15.
 */
public class Category {

    //private String category;
    private boolean isSalesTaxExempted;

    public Category(boolean isSalesTaxExempted){
        //this.category = category;
        this.isSalesTaxExempted = isSalesTaxExempted;
    }

    /*public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }*/

    public boolean isSalesTaxExempted() {
        return isSalesTaxExempted;
    }

    public void setSalesTaxExempted(boolean salesTaxExempted) {
        isSalesTaxExempted = salesTaxExempted;
    }
}
